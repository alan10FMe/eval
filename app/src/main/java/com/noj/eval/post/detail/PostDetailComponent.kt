package com.noj.eval.post.detail

import com.noj.eval.data.EvalRepositoryComponent
import com.noj.eval.util.ActivityScoped
import dagger.Component

@ActivityScoped
@Component(dependencies = arrayOf(EvalRepositoryComponent::class), modules = arrayOf(PostDetailPresenterModule::class))
interface PostDetailComponent {

    fun inject(postDetailFragment: PostDetailFragment)

}
