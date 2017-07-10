package com.noj.eval.post.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noj.eval.R
import com.noj.eval.model.Post
import kotlinx.android.synthetic.main.item_posts.view.*

class PostsAdapter(
        var posts: MutableList<Post>,
        var listener: (Post) -> Unit
) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int) = PostsAdapter.ViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_posts, viewGroup, false))

    override fun onBindViewHolder(holder: PostsAdapter.ViewHolder, position: Int)
            = holder.bind(posts[position], listener)

    override fun getItemCount() = posts.size

    fun addAll(posts: List<Post>) {
        this.posts.clear()
        this.posts.addAll(posts)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Post, listener: (Post) -> Unit) = with(itemView) {
            post_title_text.text = post.title
            post_message_text.text = post.message
            post_card.setOnClickListener { listener(post) }
        }
    }

}
