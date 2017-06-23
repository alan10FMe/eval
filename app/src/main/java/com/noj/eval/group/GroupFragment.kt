package com.noj.eval.group

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.noj.eval.BaseFragment
import com.noj.eval.EvalApplication
import com.noj.eval.R
import com.noj.eval.model.Group
import com.noj.eval.util.disableBackArrow
import kotlinx.android.synthetic.main.fragment_group.*
import org.jetbrains.anko.support.v4.act
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

class GroupFragment : BaseFragment(), GroupContract.View,
        BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    @Inject
    lateinit var presenter: GroupPresenter
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
        create_button.setOnClickListener(this)
        presenter.start()
    }

    override fun onStart() {
        super.onStart()
        disableBackArrow()
    }

    override fun displayGroupsCreated(groups: List<Group>) {
        adapter.replaceAll(groups, this::groupClicked)
        adapter.notifyDataSetChanged()
    }

    override fun displayGroupsAccepted(groups: List<Group>) {
        adapter.replaceAll(groups, {})
        adapter.notifyDataSetChanged()
    }

    override fun displayGroupCreated(group: Group) {
        toast("Grupo ${group.name} created")
    }

    fun groupClicked(group: Group) {
        presenter.onGroupClicked(group)
    }

    override fun displayGroupDetail(group: Group) {
        toast("Go to group ${group.id}")
    }

    override fun displayCreateScreen() {
        fragmentManager
                .beginTransaction()
                .replace(android.R.id.content, GroupCreateDialog(this::onSaveDialogClicked))
                .addToBackStack(null).commit()
    }

    fun onSaveDialogClicked(group: Group) {
        presenter.onSaveClicked(group)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.create_button -> presenter.onCreateGroupClicked()
        }
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.groups_item_created -> {
                presenter.onGroupsCreatedClicked()
                create_button.visibility = View.VISIBLE
            }
            R.id.groups_item_accepted -> {
                presenter.onGroupsAcceptedClicked()
                create_button.visibility = View.GONE
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

}
