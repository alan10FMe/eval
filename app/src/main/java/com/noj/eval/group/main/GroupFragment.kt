package com.noj.eval.group.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import com.noj.eval.BaseFragment
import com.noj.eval.R
import com.noj.eval.group.admin.AdminGroupFragment
import com.noj.eval.group.search.SearchGroupFragment
import com.noj.eval.model.Group
import com.noj.eval.util.disableBackArrow
import com.noj.eval.util.evalRepositoryComponent
import com.noj.eval.util.snack
import kotlinx.android.synthetic.main.fragment_group.*
import org.jetbrains.anko.support.v4.ctx
import javax.inject.Inject

class GroupFragment : BaseFragment(), GroupContract.View,
        BottomNavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var presenter: GroupPresenter
    var createMenuItem: MenuItem? = null
    var searchMenuItem: MenuItem? = null
    val adapter: GroupAdapter

    init {
        adapter = GroupAdapter(mutableListOf<Group>(), this::groupClicked)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerGroupComponent
                .builder()
                .groupPresenterModule(GroupPresenterModule(this))
                .evalRepositoryComponent(evalRepositoryComponent)
                .build()
                .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_group, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        disableBackArrow()
        groups_recycler.layoutManager = LinearLayoutManager(ctx)
        groups_recycler.adapter = adapter
        bottom_navigation.setOnNavigationItemSelectedListener(this)
        presenter.start()
    }

    override fun onResume() {
        super.onResume()
        onNavigationItemSelected(bottom_navigation.menu.findItem(bottom_navigation.selectedItemId))
    }

    override fun displayGroupsCreated(groups: List<Group>) {
        adapter.replaceAll(groups, this::groupClicked)
        createMenuItem?.isVisible = true
        searchMenuItem?.isVisible = false
    }

    override fun displayGroupsAccepted(groups: List<Group>) {
        adapter.replaceAll(groups, {})
        createMenuItem?.isVisible = false
        searchMenuItem?.isVisible = true
    }

    override fun displayGroupCreated(name: String) {
        snack(getString(R.string.group_created, name))
    }

    private fun groupClicked(groupId: Long) {
        presenter.onGroupClicked(groupId)
    }

    override fun displayGroupDetail(groupId: Long) {
        val fragmentAdminGroup = AdminGroupFragment.newInstance(groupId)
        replaceFragment(fragmentAdminGroup)
    }

    override fun displaySearchScreen() {
        val fragmentSearchGroup = SearchGroupFragment.newInstance()
        replaceFragment(fragmentSearchGroup)
    }

    override fun displayCreateScreen() {
        replaceFragment(GroupCreateDialog(this::onSaveDialogClicked))
    }

    private fun onSaveDialogClicked(group: Group) {
        presenter.onSaveClicked(group)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.groups_item_created -> presenter.onGroupsCreatedClicked()
            R.id.groups_item_accepted -> presenter.onGroupsAcceptedClicked()
            else -> error("Operation not supported")
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_groups, menu)
        createMenuItem = menu.getItem(0)
        searchMenuItem = menu.getItem(1)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        when (bottom_navigation.selectedItemId) {
            R.id.groups_item_created -> {
                createMenuItem?.isVisible = true
                searchMenuItem?.isVisible = false
            }
            R.id.groups_item_accepted -> {
                createMenuItem?.isVisible = false
                searchMenuItem?.isVisible = true
            }
            else -> error("Operation not supported")
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.create_group_item -> presenter.onCreateGroupClicked()
            R.id.search_group_item -> presenter.onSearchGroupClicked()
            else -> error("Not supported operation")
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        fun newInstance(): GroupFragment {
            return GroupFragment()
        }
    }

}
