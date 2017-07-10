package com.noj.eval.post.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import com.noj.eval.BaseFragment
import com.noj.eval.R
import com.noj.eval.model.Post
import com.noj.eval.post.detail.PostDetailFragment
import com.noj.eval.util.enableBackArrow
import com.noj.eval.util.evalRepositoryComponent
import com.noj.eval.util.snack
import kotlinx.android.synthetic.main.fragment_posts.*
import org.jetbrains.anko.support.v4.ctx
import javax.inject.Inject

class PostsFragment : BaseFragment(), PostsContract.View {

    @Inject
    lateinit var presenter: PostsPresenter
    private val postsAdapter: PostsAdapter

    init {
        postsAdapter = PostsAdapter(mutableListOf<Post>()) {
            post ->
            presenter.onPostClicked(post)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerPostsComponent.builder()
                .postsPresenterModule(PostsPresenterModule(this, arguments.getLong(PostsFragment.ARG_GROUP_ID)))
                .evalRepositoryComponent(evalRepositoryComponent)
                .build()
                .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        enableBackArrow()
        posts_recycler.layoutManager = LinearLayoutManager(ctx)
        posts_recycler.adapter = postsAdapter
        presenter.start()
    }

    override fun displayPosts(posts: List<Post>) {
        postsAdapter.addAll(posts)
    }

    override fun navigateToPost(postId: Long) {
        replaceFragment(PostDetailFragment.newInstance(postId))
    }

    override fun displayCreateScreen() {
        replaceFragment(PostsCreateDialog(this::onSaveDialogClicked))
    }

    override fun displayPostCreated(title: String) {
        snack(getString(R.string.posts_created, title))
    }

    private fun onSaveDialogClicked(title: String, message: String) {
        presenter.onSavePostClicked(title, message)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_posts, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.create_post_item -> presenter.onCreatePostClicked()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private val ARG_GROUP_ID = "groupId"
        fun newInstance(groupId: Long): PostsFragment {
            val fragment = PostsFragment()
            val args = Bundle()
            args.putLong(ARG_GROUP_ID, groupId)
            fragment.arguments = args
            return fragment
        }
    }

}
