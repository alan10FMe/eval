package com.noj.eval.data

import com.noj.eval.model.Group
import com.noj.eval.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EvalRepository @Inject internal constructor(
        private @Remote val remoteDataSource: EvalDataSource,
        private @Local val localRemoteDataSource: EvalDataSource,
        private @SharedPreferences val sharedPreferences: EvalDataSource
) : EvalDataSource {

    override var user: User
        get() = remoteDataSource.user
        set(value) {
            remoteDataSource.user = value
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

}
