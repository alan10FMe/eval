package com.noj.eval.post.detail

import com.noj.eval.data.EvalRepository
import com.noj.eval.model.Post
import javax.inject.Inject

class PostDetailPresenter @Inject internal constructor(
        override val view: PostDetailContract.View,
        private val repository: EvalRepository,
        private val postId: Long
) : PostDetailContract.Presenter {

    lateinit var post: Post

    override fun start() {
        post = repository.getPost(postId)
        view.displayPost(post.title, post.message)
        view.displayAnswers(post.answers)
    }

    override fun postAnswer(answer: String) {
        if (answer.isNotBlank()) {
            val answerResponse = repository.createAnswer(post.id, Post(message = answer))
            view.addAnswer(answerResponse)
            view.resetSendMessage()
        }
    }

}
