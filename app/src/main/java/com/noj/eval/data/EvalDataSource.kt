package com.noj.eval.data

import com.noj.eval.model.Group
import com.noj.eval.model.User

interface EvalDataSource {

    var user: User

    var userUid: String

    var groupsCreated: List<Group>

    var groupsAccepted: List<Group>

    fun createGroup(group: Group): Group

}
