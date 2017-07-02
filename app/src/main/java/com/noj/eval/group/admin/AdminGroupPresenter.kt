package com.noj.eval.group.admin

import com.noj.eval.data.EvalRepository
import com.noj.eval.model.Group
import com.noj.eval.model.User
import javax.inject.Inject

class AdminGroupPresenter @Inject() internal constructor(
        override val view: AdminGroupContract.View,
        private val repository: EvalRepository,
        private val groupId: Long
) : AdminGroupContract.Presenter {

    lateinit var group: Group
    lateinit var requesters: MutableList<User>
    lateinit var participants: MutableList<User>

    override fun start() {
        group = repository.getGroup(groupId)
        requesters = group.requesters.sortedBy { it.name }.toMutableList()
        participants = group.participants.sortedBy { it.name }.toMutableList()
        view.displayRequesters(requesters)
        view.displayParticipants(participants)
        validateListSizes()
    }

    override fun acceptUser(userId: Long) {
        val user = requesters.single { it.id == userId }
        requesters.remove(user)
        participants.add(user)
        view.displayUserAccepted(user)
        validateListSizes()
    }

    override fun rejectUser(userId: Long) {
        val user = requesters.single { it.id == userId }
        requesters.remove(user)
        view.displayUserRejected(user)
        validateListSizes()
    }

    override fun removeParticipant(userId: Long) {
        val user = participants.single { it.id == userId }
        participants.remove(user)
        view.displayUserRemoved(user)
        validateListSizes()
    }

    private fun validateListSizes() {
        if (requesters.size == 0) {
            view.hideRequesters()
        }
        if (participants.size == 0) {
            view.hideParticipants()
        }
    }

}