package com.noj.eval.data.remote

import com.noj.eval.data.EvalDataSource
import com.noj.eval.data.Remote
import com.noj.eval.model.Group
import com.noj.eval.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Remote
class RemoteDataSource @Inject internal constructor() : EvalDataSource {

    override var user: User
        get() = TODO("not implemented")
        set(value) {}

    override var userUid: String
        get() = TODO("not implemented")
        set(value) {}

    override var groupsCreated: List<Group>
        get() = TODO("not implemented")
        set(value) {}

    override var groupsAccepted: List<Group>
        get() = TODO("not implemented")
        set(value) {}

    override fun createGroup(group: Group): Group {
        TODO("not implemented")
    }

}
