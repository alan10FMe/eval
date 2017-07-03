package com.noj.eval.group.main

import com.noj.eval.BasePresenter
import com.noj.eval.BaseView
import com.noj.eval.model.Group

interface GroupContract {

    interface View : BaseView {

        fun displayGroupsCreated(groups: List<Group>)

        fun displayGroupsAccepted(groups: List<Group>)

        fun displayCreateScreen()

        fun displaySearchScreen()

        fun displayGroupCreated(name: String)

        fun displayGroupDetail(groupId: Long)

    }

    interface Presenter : BasePresenter<View> {

        fun onGroupsCreatedClicked()

        fun onGroupsAcceptedClicked()

        fun onCreateGroupClicked()

        fun onSearchGroupClicked()

        fun onSaveClicked(group: Group)

        fun onGroupClicked(groupId: Long)

    }

}
