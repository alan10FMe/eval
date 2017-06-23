package com.noj.eval.group

import com.noj.eval.data.EvalRepository
import com.noj.eval.model.Group
import javax.inject.Inject

class GroupPresenter @Inject() internal constructor(
        val view: GroupContract.View,
        val repository: EvalRepository
) : GroupContract.Presenter {

    private var groupsCreated: MutableList<Group>? = null
        get() {
            if (field == null) {
                field = repository.groupsCreated.toMutableList()
            }
            return field
        }

    private var groupsAccepted: MutableList<Group>? = null
        get() {
            if (field == null) {
                field = repository.groupsAccepted.toMutableList()
            }
            return field
        }

    override fun start() {
        view.displayGroupsCreated(groupsCreated!!)
    }

    override fun onGroupsCreatedClicked() {
        view.displayGroupsCreated(groupsCreated!!)
    }

    override fun onGroupsAcceptedClicked() {
        view.displayGroupsAccepted(groupsAccepted!!)
    }

    override fun onCreateGroupClicked() {
        view.displayCreateScreen()
    }

    override fun onSaveClicked(group: Group) {
        val groupCreated = repository.createGroup(group)
        groupsCreated?.add(groupCreated)
        groupsCreated?.sortBy { it.name }
        view.displayGroupCreated(groupCreated)
    }

    override fun onGroupClicked(group: Group) {
        view.displayGroupDetail(group)
    }

}
