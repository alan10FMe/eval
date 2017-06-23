package com.noj.eval.group.admin

import dagger.Module
import dagger.Provides

@Module
class AdminGroupPresenterModule(val view: AdminGroupContract.View, val groupId: Long) {

    @Provides
    fun provideAdminGroupContractView(): AdminGroupContract.View {

        return view

    }

    @Provides
    fun provideGroupId() = groupId

}
