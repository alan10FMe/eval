package com.noj.eval.post.main

import com.noj.eval.data.EvalRepository
import com.noj.eval.model.Post
import javax.inject.Inject

class PostsPresenter @Inject internal constructor(
        override val view: PostsContract.View,
        private val repository: EvalRepository,
        private val groupId: Long
) : PostsContract.Presenter {

    val posts: MutableList<Post> by lazy {
        repository.getPosts(groupId).toMutableList()
    }

    override fun start() {
        view.displayPosts(posts)
    }

    override fun onCreatePostClicked() {
        view.displayCreateScreen()
    }

    override fun onSavePostClicked(title: String, message: String) {
        val post = repository.createPosts(Post(title = title, message = message))
        posts.add(0, post)
        view.displayPostCreated(post.title)
        view.displayPosts(posts)
    }

    override fun onPostClicked(post: Post) {
        view.navigateToPost(post.id)
    }

}
