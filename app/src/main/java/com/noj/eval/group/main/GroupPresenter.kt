package com.noj.eval.group.main

import com.noj.eval.data.EvalRepository
import com.noj.eval.model.Group
import javax.inject.Inject

class GroupPresenter @Inject() internal constructor(
        override val view: GroupContract.View,
        val repository: EvalRepository
) : GroupContract.Presenter {

    override fun start() {
        view.displayGroupsCreated(repository.groupsCreated)
    }

    override fun onGroupsCreatedClicked() {
        view.displayGroupsCreated(repository.groupsCreated)
    }

    override fun onGroupsAcceptedClicked() {
        view.displayGroupsAccepted(repository.groupsAccepted)
    }

    override fun onCreateGroupClicked() {
        view.displayCreateScreen()
    }

    override fun onSaveClicked(group: Group) {
        view.showLoading()
        repository.createGroup(group)
        view.dismissLoading()
        view.displayGroupCreated(group.name)
    }

    override fun onGroupClicked(groupId: Long) {
        view.displayGroupDetail(groupId)
    }

}
