package com.noj.eval.post.detail

import com.noj.eval.BasePresenter
import com.noj.eval.BaseView
import com.noj.eval.model.Post

interface PostDetailContract {

    interface View : BaseView {

        fun displayPost(title: String, message: String)

        fun displayAnswers(answers: List<Post>)

        fun addAnswer(answer: Post)

        fun resetSendMessage()

    }

    interface Presenter : BasePresenter<View> {

        fun postAnswer(answer: String)

    }

}
