package com.noj.eval.post.main

import com.noj.eval.data.EvalRepositoryComponent
import com.noj.eval.util.ActivityScoped
import dagger.Component

@ActivityScoped
@Component(dependencies = arrayOf(EvalRepositoryComponent::class), modules = arrayOf(PostsPresenterModule::class))
interface PostsComponent {

    fun inject(postsFragment: PostsFragment)

}
