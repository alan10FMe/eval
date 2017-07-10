package com.noj.eval.post.main

import dagger.Module
import dagger.Provides

@Module
class PostsPresenterModule(val view: PostsContract.View, val groupId: Long) {

    @Provides
    fun providePostsContractView() = view

    @Provides
    fun provideGroupId() = groupId
}
