package com.noj.eval.data.remote

import com.noj.eval.model.Group
import com.noj.eval.model.User

interface RemoteData {

    fun createUser(user: User): User

    fun getGroupsCreated(user: User): List<Group>

    fun getGroupsAccepted(user: User): List<Group>

    fun createGroup(group: Group): Group

}
