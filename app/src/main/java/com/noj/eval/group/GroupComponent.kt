package com.noj.eval.group

import com.noj.eval.data.EvalRepositoryComponent
import com.noj.eval.util.ActivityScoped
import dagger.Component

@ActivityScoped
@Component(dependencies = arrayOf(EvalRepositoryComponent::class), modules = arrayOf(GroupPresenterModule::class))
interface GroupComponent {

    fun inject(groupFragment: GroupFragment)

}