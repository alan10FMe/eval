package com.noj.eval.group.search

import dagger.Module
import dagger.Provides

@Module
class SearchGroupPresenterModule(val view: SearchGroupContract.View) {

    @Provides
    fun provideSearchGroupContractView() = view

}
