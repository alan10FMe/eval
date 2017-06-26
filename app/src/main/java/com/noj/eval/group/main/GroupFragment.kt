package com.noj.eval.group.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import com.noj.eval.BaseFragment
import com.noj.eval.EvalApplication
import com.noj.eval.R
import com.noj.eval.group.admin.AdminGroupFragment
import com.noj.eval.model.Group
import com.noj.eval.util.disableBackArrow
import com.noj.eval.util.snack
import kotlinx.android.synthetic.main.fragment_group.*
import org.jetbrains.anko.support.v4.act
import org.jetbrains.anko.support.v4.ctx
import javax.inject.Inject

class GroupFragment : BaseFragment(), GroupContract.View,
        BottomNavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var presenter: GroupPresenter
    lateinit var createMenuItem: MenuItem
    val adapter: GroupAdapter

    init {
        adapter = GroupAdapter(mutableListOf<Group>(), this::groupClicked)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerGroupComponent
                .builder()
                .groupPresenterModule(GroupPresenterModule(this))
                .evalRepositoryComponent((act.application as EvalApplication).evalRepositoryComponent)
                .build()
                .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_group, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        groups_recycler.layoutManager = LinearLayoutManager(ctx)
        groups_recycler.adapter = adapter
        bottom_navigation.setOnNavigationItemSelectedListener(this)
        presenter.start()
    }

    override fun onStart() {
        super.onStart()
        disableBackArrow()
    }

    override fun displayGroupsCreated(groups: List<Group>) {
        adapter.replaceAll(groups, this::groupClicked)
    }

    override fun displayGroupsAccepted(groups: List<Group>) {
        adapter.replaceAll(groups, {})
    }

    override fun displayGroupCreated(name: String) {
        snack("Grupo $name created")
    }

    fun groupClicked(groupId: Long) {
        presenter.onGroupClicked(groupId)
    }

    override fun displayGroupDetail(groupId: Long) {
        val fragmentAdminGroup = AdminGroupFragment.newInstance(groupId)
        replaceFragment(fragmentAdminGroup)
    }

    override fun displayCreateScreen() {
        replaceFragment(GroupCreateDialog(this::onSaveDialogClicked))
    }

    fun onSaveDialogClicked(group: Group) {
        presenter.onSaveClicked(group)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.groups_item_created -> {
                presenter.onGroupsCreatedClicked()
                createMenuItem.isVisible = true
            }
            R.id.groups_item_accepted -> {
                presenter.onGroupsAcceptedClicked()
                createMenuItem.isVisible = false
            }
            else -> throw IllegalArgumentException("Operation not supported")
        }
        return true
    }

    companion object {
        fun newInstance(): GroupFragment {
            return GroupFragment()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_groups, menu)
        createMenuItem = menu.getItem(0)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.create_group_item -> presenter.onCreateGroupClicked()
        }
        return super.onOptionsItemSelected(item)
    }

}
