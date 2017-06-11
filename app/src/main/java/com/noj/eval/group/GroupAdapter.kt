package com.noj.eval.group

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noj.eval.R
import com.noj.eval.model.Group
import kotlinx.android.synthetic.main.item_group.view.*

class GroupAdapter(
        var groups: MutableList<Group>,
        var listener: (Group) -> Unit
) : Adapter<GroupAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int) =
            ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_group, viewGroup, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(groups[position], listener)

    override fun getItemCount() = groups.size

    fun replaceAll(newGroups: List<Group>, newListener: (Group) -> Unit) {
        groups.clear()
        groups.addAll(newGroups)
        listener = newListener
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(group: Group, listener: (Group) -> Unit) = with(itemView) {
            group_name_text.text = group.name
            group_creator_text.text = group.creator.name
            group_card.setOnClickListener { listener(group) }
        }

    }

}
