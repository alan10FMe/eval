package com.noj.eval.group.search

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noj.eval.BaseFragment
import com.noj.eval.R
import com.noj.eval.model.Group
import com.noj.eval.util.enableBackArrow
import com.noj.eval.util.evalRepositoryComponent
import com.noj.eval.util.hideKeyboard
import com.noj.eval.util.snack
import kotlinx.android.synthetic.main.fragment_search_group.*
import org.jetbrains.anko.onQueryTextListener
import org.jetbrains.anko.support.v4.ctx
import javax.inject.Inject

class SearchGroupFragment : BaseFragment(), SearchGroupContract.View {

    @Inject
    lateinit var presenter: SearchGroupPresenter
    val adapter: SearchGroupAdapter = SearchGroupAdapter(mutableListOf(), this::requestAccess)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerSearchGroupComponent.builder()
                .searchGroupPresenterModule(SearchGroupPresenterModule(this))
                .evalRepositoryComponent(evalRepositoryComponent)
                .build()
                .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_search_group, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        search_relative.layoutManager = LinearLayoutManager(ctx) as RecyclerView.LayoutManager?
        search_relative.adapter = adapter
        search_view.onQueryTextListener {
            onQueryTextSubmit {
                hideKeyboard()
                presenter.onSearchGroupByEmail(it!!)
                true
            }
        }
        enableBackArrow()
        presenter.start()
    }

    override fun displayGroups(groups: List<Group>) {
        adapter.replaceAll(groups)
    }

    private fun requestAccess(group: Group) {
        presenter.onRequestAccess(group)
    }

    override fun removeGroup(groupId: Long) {
        adapter.remove(groupId)
    }

    override fun displayAccessRequested(groupName: String) {
        snack(getString(R.string.search_group_access_requested, groupName))
    }

    companion object {
        fun newInstance(): SearchGroupFragment {
            return SearchGroupFragment()
        }
    }

}
