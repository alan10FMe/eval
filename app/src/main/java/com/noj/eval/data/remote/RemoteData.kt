package com.noj.eval.data.remote

import com.noj.eval.model.Group
import com.noj.eval.model.User

interface RemoteData {

    fun createUser(user: User): User

    var groupsCreated: List<Group>

    var groupsAccepted: List<Group>

    fun createGroup(group: Group): Group

}
