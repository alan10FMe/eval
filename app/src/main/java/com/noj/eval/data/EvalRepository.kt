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

    override var user: User
        get() = sharedPreferences.user
        set(value) {
            sharedPreferences.user = value
        }

    override var userUid: String
        get() = sharedPreferences.userUid
        set(value) {
            sharedPreferences.userUid = value
        }

    override var groupsCreated: List<Group>
        get() = remoteDataSource.groupsCreated
        set(value) {
            TODO("not implemented")
        }

    override var groupsAccepted: List<Group>
        get() = remoteDataSource.groupsAccepted
        set(value) {
            TODO("not implemented")
        }

    override fun createGroup(group: Group): Group {
        return remoteDataSource.createGroup(group)
    }

    override fun createUser(user: User): User {
        return remoteDataSource.createUser(user)
    }

}
