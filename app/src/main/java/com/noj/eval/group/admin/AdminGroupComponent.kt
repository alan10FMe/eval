package com.noj.eval.group.admin

import com.noj.eval.data.EvalRepositoryComponent
import com.noj.eval.util.ActivityScoped
import dagger.Component

@ActivityScoped
@Component(dependencies = arrayOf(EvalRepositoryComponent::class), modules = arrayOf(AdminGroupPresenterModule::class))
interface AdminGroupComponent {

    fun inject(adminGroupFragment: AdminGroupFragment)

}
