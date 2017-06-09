package com.noj.eval.data.remote

import com.noj.eval.data.EvalDataSource
import com.noj.eval.data.Remote
import com.noj.eval.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Remote
class RemoteDataSource @Inject internal constructor() : EvalDataSource {

    override fun saveUser(user: User) {
        throw RemoteException("Error")
    }

    override fun saveUserUid(uid: String) {
        TODO("not implemented")
    }

    override fun getUserUid(): String {
        TODO("not implemented")
    }

}