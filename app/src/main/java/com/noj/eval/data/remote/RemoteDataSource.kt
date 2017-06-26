package com.noj.eval.data.remote

import com.noj.eval.model.Group
import com.noj.eval.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject internal constructor() : RemoteData {

    override fun createUser(user: User): User {
        return User()
    }

    override fun getGroupsCreated(userId: Long): List<Group> {
        return emptyList()
    }

    override fun getGroupsAccepted(userId: Long): List<Group> {
        return emptyList()
    }

    override fun createGroup(group: Group): Group {
        return Group()
    }

    override fun getGroup(userId: Long, groupId: Long): Group {
        return Group()
    }

    override fun acceptUser(userId: Long, groupId: Long) {

    }

    override fun rejectUser(userId: Long, groupId: Long) {

    }

}
