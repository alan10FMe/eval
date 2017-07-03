package com.noj.eval.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.noj.eval.BaseActivity
import com.noj.eval.R
import com.noj.eval.home.HomeActivity
import com.noj.eval.util.evalRepositoryComponent
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View,
        GoogleApiClient.OnConnectionFailedListener, OnCompleteListener<AuthResult> {

    @Inject
    lateinit var presenter: LoginPresenter
    lateinit var googleSignIn: GoogleSignInOptions
    lateinit var googleApiClient: GoogleApiClient
    lateinit var fireBaseAuth: FirebaseAuth
    val RC_SIGN_IN = 43

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        DaggerLoginComponent
                .builder()
                .loginPresenterModule(LoginPresenterModule(this))
                .evalRepositoryComponent(evalRepositoryComponent)
                .build()
                .inject(this)

        presenter.start()

        login_button.setOnClickListener {
            presenter.signIn()
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.validateUser(fireBaseAuth.currentUser)
    }

    override fun initializeLoginComponents() {
        googleSignIn = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

        googleApiClient = GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignIn)
                .build()

        fireBaseAuth = FirebaseAuth.getInstance()
    }

    override fun signInWithGoogle() {
        val signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient)
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun startApplication() {
        startActivity<HomeActivity>()
        finish()
    }

    override fun onInvalidUser() {
        login_button.visibility = View.VISIBLE
    }

    override fun onValidUser() {
        presenter.validateAndSaveUser(fireBaseAuth.currentUser)
    }

    override fun onConnectionFailed(connectionResult: ConnectionResult) {
        showGeneralError()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val result: GoogleSignInResult = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            presenter.processResultSignUp(result)
        }
    }

    override fun fireBaseAuthWithGoogle(account: GoogleSignInAccount?) {
        val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
        fireBaseAuth.signInWithCredential(credential).addOnCompleteListener(this)
    }

    override fun onComplete(result: Task<AuthResult>) {
        presenter.onCompleteAuthentication(result)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
