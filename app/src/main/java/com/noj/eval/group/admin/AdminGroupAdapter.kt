package com.noj.eval.group.admin

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noj.eval.R
import com.noj.eval.model.User
import kotlinx.android.synthetic.main.item_user.view.*

class AdminGroupAdapter(
        val users: MutableList<User>,
        val isRequesting: Boolean,
        val acceptListener: (Long) -> Unit,
        val rejectListener: (Long) -> Unit
) : Adapter<AdminGroupAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int)
            = ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_user, viewGroup, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(users[position], isRequesting, acceptListener, rejectListener)

    override fun getItemCount() = users.size

    fun addAll(users: List<User>) {
        this.users.addAll(users)
        notifyDataSetChanged()
    }

    fun add(user: User) {
        users.add(user)
        users.sortBy { it.name }
        notifyDataSetChanged()
    }

    fun remove(user: User) {
        users.remove(user)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: User,
                 isRequesting: Boolean,
                 acceptListener: (Long) -> Unit,
                 rejectListener: (Long) -> Unit) = with(itemView) {
            user_name_text.text = user.name
            user_email_text.text = user.email
            reject_button.setOnClickListener { rejectListener(user.id) }
            if (isRequesting) {
                accept_button.visibility = View.VISIBLE
                accept_button.setOnClickListener { acceptListener(user.id) }
            } else {
                accept_button.visibility = View.GONE
            }
        }

    }
}