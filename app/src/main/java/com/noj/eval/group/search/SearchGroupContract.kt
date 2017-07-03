package com.noj.eval.group.search

import com.noj.eval.BasePresenter
import com.noj.eval.BaseView
import com.noj.eval.model.Group

interface SearchGroupContract {

    interface View : BaseView {

        fun displayGroups(groups: List<Group>)

        fun removeGroup(groupId: Long)

        fun displayAccessRequested(groupName: String)

    }

    interface Presenter : BasePresenter<View> {

        fun onSearchGroupByEmail(email: String)

        fun onRequestAccess(group: Group)

    }

}
