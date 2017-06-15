package com.noj.eval.login

import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.noj.eval.data.EvalRepository
import com.noj.eval.model.User
import javax.inject.Inject

class LoginPresenter @Inject() internal constructor(
        val view: LoginContract.View,
        val repository: EvalRepository
) : LoginContract.Presenter {

    override fun start() {
        view.initializeLoginComponents()
    }

    override fun validateUser(fireBaseUser: FirebaseUser?) {
        if (fireBaseUser != null) {
            view.onValidUser()
        } else {
            view.onInvalidUser()
        }
    }

    override fun signIn() {
        view.signInWithGoogle()
    }

    override fun processResultSignUp(result: GoogleSignInResult) {
        if (result.isSuccess) {
            view.fireBaseAuthWithGoogle(result.signInAccount)
        } else {
            view.onInvalidUser()
        }
    }

    override fun onCompleteAuthentication(result: Task<AuthResult>) {
        if (result.isSuccessful) {
            view.onValidUser()
        } else {
            view.onInvalidUser()
        }
    }

    override fun validateAndSaveUser(fireBaseUser: FirebaseUser?) {
        if (repository.userUid.isBlank()) {
            repository.user = createUser(fireBaseUser)
            repository.userUid = fireBaseUser!!.uid
        }
        view.startApplication()
    }

    fun createUser(fireBaseUser: FirebaseUser?): User {
        return User(
                uid = fireBaseUser!!.uid,
                name = fireBaseUser.displayName!!,
                email = fireBaseUser.email!!)
    }

}
