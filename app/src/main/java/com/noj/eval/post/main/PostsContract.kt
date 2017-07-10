package com.noj.eval.post.main

import com.noj.eval.BasePresenter
import com.noj.eval.BaseView
import com.noj.eval.model.Post

interface PostsContract {

    interface View : BaseView {

        fun displayPosts(posts: List<Post>)

        fun displayCreateScreen()

        fun displayPostCreated(title: String)

    }

    interface Presenter : BasePresenter<View> {

        fun onCreatePostClicked()

        fun onSavePostClicked(title: String, message: String)

    }

}
