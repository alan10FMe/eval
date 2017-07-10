package com.noj.eval.post.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noj.eval.BaseFragment
import com.noj.eval.R
import com.noj.eval.model.Post
import com.noj.eval.util.evalRepositoryComponent
import com.noj.eval.util.hideKeyboard
import com.noj.eval.util.initialize
import kotlinx.android.synthetic.main.fragment_post_detail.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.support.v4.ctx
import javax.inject.Inject

class PostDetailFragment : BaseFragment(), PostDetailContract.View {

    @Inject
    lateinit var presenter: PostDetailPresenter
    private val adapter: PostDetailAdapter

    init {
        adapter = PostDetailAdapter(mutableListOf<Post>())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerPostDetailComponent.builder()
                .postDetailPresenterModule(PostDetailPresenterModule(this, arguments.getLong(ARG_POST_ID)))
                .evalRepositoryComponent(evalRepositoryComponent)
                .build().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_post_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        answers_recycler.initialize(adapter, ctx)
        send_image.onClick {
            presenter.postAnswer(message_edit.text.toString())
        }
        presenter.start()
    }

    override fun displayPost(title: String, message: String) {
        title_text.text = title
        message_text.text = message
    }

    override fun displayAnswers(answers: List<Post>) {
        adapter.addAll(answers)
    }

    override fun addAnswer(answer: Post) {
        adapter.add(answer)
    }

    override fun resetSendMessage() {
        hideKeyboard()
        message_edit.setText("")
    }

    companion object {
        private val ARG_POST_ID = "postId"
        fun newInstance(postId: Long): PostDetailFragment {
            val fragment = PostDetailFragment()
            val args = Bundle()
            args.putLong(ARG_POST_ID, postId)
            fragment.arguments = args
            return fragment
        }
    }

}
