package com.noj.eval.login

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.noj.eval.BasePresenter
import com.noj.eval.BaseView

interface LoginContract {

    interface Presenter : BasePresenter<View> {

        fun start(fireBaseUser: FirebaseUser?)

        fun signIn()

        fun processResultSignUp(result: GoogleSignInResult)

        fun onCompleteAuthentication(result: Task<AuthResult>)

        fun validateAndSaveUser(fireBaseUser: FirebaseUser?)

    }

    interface View : BaseView {

        fun initializeView()

        fun initializeLoginComponents()

        fun startApplication()

        fun onInvalidUser()

        fun onValidUser()

        fun signInWithGoogle()

        fun fireBaseAuthWithGoogle(account: GoogleSignInAccount?)

    }

}
