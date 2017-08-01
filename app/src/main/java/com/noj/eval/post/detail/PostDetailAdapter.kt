package com.noj.eval.post.detail

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noj.eval.R
import com.noj.eval.model.Post
import kotlinx.android.synthetic.main.item_answer.view.*

class PostDetailAdapter(
        private val answers: MutableList<Post>
) : RecyclerView.Adapter<PostDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int)
            = ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_answer, viewGroup, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(answers[position])

    override fun getItemCount() = answers.size

    fun add(answer: Post) {
        this.answers.add(answer)
        notifyDataSetChanged()
    }

    fun addAll(answers: List<Post>) {
        this.answers.addAll(answers)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(post: Post) = with(itemView) {
            answer_text.text = post.message
        }

    }

}
