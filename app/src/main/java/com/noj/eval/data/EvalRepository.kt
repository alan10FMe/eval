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
        remoteDataSource.getGroupsCreated(sharedPreferences.user).toMutableList()
    }

    override val groupsAccepted: MutableList<Group> by lazy {
        remoteDataSource.getGroupsAccepted(sharedPreferences.user).toMutableList()
    }

    override fun createUser(user: User) {
        if (sharedPreferences.userId == 0L) {
            val newUser = remoteDataSource.createUser(user)
            sharedPreferences.storeUserData(newUser)
        }
    }

    override fun createGroup(group: Group): Group {
        val groupCreated = remoteDataSource.createGroup(group.copy(creator = sharedPreferences.user))
        groupsCreated.add(groupCreated)
        groupsCreated.sortBy { it.name }
        return groupCreated
    }

}
