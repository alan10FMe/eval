package com.noj.eval.login

import dagger.Module
import dagger.Provides

@Module
class LoginPresenterModule(val view: LoginContract.View) {

    @Provides
    fun provideLoginContractView(): LoginContract.View {

        return view

    }

}