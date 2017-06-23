package com.noj.eval.data

import com.noj.eval.data.local.LocalData
import com.noj.eval.data.remote.RemoteData
import com.noj.eval.data.sharedpreferences.SharedPreferencesData
import com.noj.eval.model.Group
import com.noj.eval.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EvalRepository @Inject internal constructor(
        private val remoteDataSource: RemoteData,
        private val localRemoteDataSource: LocalData,
        private val sharedPreferences: SharedPreferencesData
) : EvalDataSource {

    override val groupsCreated: MutableList<Group> by lazy {
        remoteDataSource.getGroupsCreated(sharedPreferences.userId).toMutableList()
    }

    override val groupsAccepted: MutableList<Group> by lazy {
        remoteDataSource.getGroupsAccepted(sharedPreferences.userId).toMutableList()
    }

    override fun createUser(user: User) {
        if (sharedPreferences.userId == 0L) {
            val newUser = remoteDataSource.createUser(user)
            sharedPreferences.storeUserData(newUser)
        }
    }

    override fun createGroup(group: Group) {
        val groupCreated = remoteDataSource.createGroup(group.copy(creator = sharedPreferences.user))
        groupsCreated.add(groupCreated)
        groupsCreated.sortBy { it.name }
    }

    override fun getGroup(groupId: Long): Group {
        return remoteDataSource.getGroup(sharedPreferences.userId, groupId)
    }

    override fun acceptUser(userId: Long, groupId: Long) {
        remoteDataSource.acceptUser(userId, groupId)
    }

    override fun rejectUser(userId: Long, groupId: Long) {
        remoteDataSource.rejectUser(userId, groupId)
    }

}
