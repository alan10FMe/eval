package com.noj.eval.group.search

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noj.eval.R
import com.noj.eval.model.Group
import kotlinx.android.synthetic.main.item_search_group.view.*

class SearchGroupAdapter(
        var groups: MutableList<Group>,
        var listener: (Group) -> Unit
) : RecyclerView.Adapter<SearchGroupAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int) = SearchGroupAdapter.ViewHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_search_group, viewGroup, false))

    override fun onBindViewHolder(holder: SearchGroupAdapter.ViewHolder, position: Int)
            = holder.bind(groups[position], listener)

    override fun getItemCount() = groups.size

    fun replaceAll(newGroups: List<Group>) {
        groups.clear()
        groups.addAll(newGroups)
        notifyDataSetChanged()
    }

    fun remove(groupId: Long) {
        groups = groups.filter { it.id != groupId }.toMutableList()
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(group: Group, listener: (Group) -> Unit) = with(itemView) {
            group_name_text.text = group.name
            group_card.setOnClickListener { listener(group) }
        }
    }

}
