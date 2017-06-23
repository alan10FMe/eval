package com.noj.eval.group.admin

import com.noj.eval.BasePresenter
import com.noj.eval.BaseView
import com.noj.eval.model.User

interface AdminGroupContract {

    interface Presenter : BasePresenter<View> {

        fun acceptUser(userId: Long)

        fun rejectUser(userId: Long)

        fun removeParticipant(userId: Long)

    }

    interface View : BaseView {

        fun displayRequesters(requesters: List<User>)

        fun hideRequesters()

        fun displayParticipants(participants: List<User>)

        fun hideParticipants()

        fun displayUserAccepted(user: User)

        fun displayUserRejected(user: User)

        fun displayUserRemoved(user: User)

    }

}