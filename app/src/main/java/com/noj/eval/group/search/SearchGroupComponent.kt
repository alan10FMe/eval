package com.noj.eval.group.search

import com.noj.eval.data.EvalRepositoryComponent
import com.noj.eval.util.ActivityScoped
import dagger.Component

@ActivityScoped
@Component(dependencies = arrayOf(EvalRepositoryComponent::class), modules = arrayOf(SearchGroupPresenterModule::class))
interface SearchGroupComponent {

    fun inject(searchGroupFragment: SearchGroupFragment)

}
