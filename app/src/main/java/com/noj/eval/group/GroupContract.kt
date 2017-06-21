package com.noj.eval.group

import com.noj.eval.BasePresenter
import com.noj.eval.BaseView
import com.noj.eval.model.Group

interface GroupContract {

    interface Presenter : BasePresenter<View> {

        fun onGroupsCreatedClicked()

        fun onGroupsAcceptedClicked()

        fun onCreateGroupClicked()

        fun onSaveClicked(group: Group)

        fun onGroupClicked(group: Group)

    }

    interface View : BaseView {

        fun displayGroupsCreated(groups: List<Group>)

        fun displayGroupsAccepted(groups: List<Group>)

        fun displayCreateScreen()

        fun displayGroupCreated(group: Group)

        fun displayGroupDetail(group: Group)

    }

}
