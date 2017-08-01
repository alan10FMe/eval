package com.noj.eval.post.detail

import dagger.Module
import dagger.Provides

@Module
class PostDetailPresenterModule(val view: PostDetailContract.View, val postId: Long) {

    @Provides
    fun providePostDetailContractView() = view

    @Provides
    fun providesPostId() = postId

}
