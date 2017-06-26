package com.noj.eval.data.remote

import com.noj.eval.model.Group
import com.noj.eval.model.User

interface RemoteData {

    fun createUser(user: User): User

    fun getGroupsCreated(userId: Long): List<Group>

    fun getGroupsAccepted(userId: Long): List<Group>

    fun createGroup(group: Group): Group

    fun getGroup(userId: Long, groupId: Long): Group

    fun acceptUser(userId: Long, groupId: Long)

    fun rejectUser(userId: Long, groupId: Long)

}
