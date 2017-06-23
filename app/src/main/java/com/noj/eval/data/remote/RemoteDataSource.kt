package com.noj.eval.data.remote

import com.noj.eval.data.EvalDataSource
import com.noj.eval.model.Group
import com.noj.eval.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject internal constructor() : RemoteData {

    override fun createUser(user: User): User {
        return User()
    }

    override var groupsCreated: List<Group>
        get() = emptyList()
        set(value) {
            error("You should not try to invoke this method")
        }

    override var groupsAccepted: List<Group>
        get() = emptyList()
        set(value) {
            error("You should not try to invoke this method")
        }

    override fun createGroup(group: Group): Group {
        return Group()
    }

}
