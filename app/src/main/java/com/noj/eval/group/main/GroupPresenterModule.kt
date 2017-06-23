package com.noj.eval.group.main

import dagger.Module
import dagger.Provides

@Module
class GroupPresenterModule(val view: GroupContract.View) {

    @Provides
    fun provideGroupContractView(): GroupContract.View {

        return view

    }

}
