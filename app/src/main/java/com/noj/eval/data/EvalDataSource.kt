package com.noj.eval.data

import com.noj.eval.model.Group
import com.noj.eval.model.User

interface EvalDataSource {

    var groupsCreated: List<Group>

    var groupsAccepted: List<Group>

    fun createUser(user: User)

    fun createGroup(group: Group): Group

}
