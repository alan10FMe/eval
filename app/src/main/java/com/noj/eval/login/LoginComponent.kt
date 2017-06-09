package com.noj.eval.login

import com.noj.eval.data.EvalRepositoryComponent
import com.noj.eval.util.ActivityScoped
import dagger.Component

@ActivityScoped
@Component(dependencies = arrayOf(EvalRepositoryComponent::class), modules = arrayOf(LoginPresenterModule::class))
interface LoginComponent {

    fun inject(loginActivity: LoginActivity)

}
