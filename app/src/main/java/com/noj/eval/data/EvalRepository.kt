package com.noj.eval.data

import com.noj.eval.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EvalRepository @Inject internal constructor(
        @Remote val remoteDataSource: EvalDataSource,
        @Local val localRemoteDataSource: EvalDataSource,
        @SharedPreferences val sharedPreferences: EvalDataSource
): EvalDataSource {

    override fun saveUser(user: User) {
        remoteDataSource.saveUser(user)
    }

    override fun saveUserUid(uid: String) {
        sharedPreferences.saveUserUid(uid)
    }

    override fun getUserUid(): String {
        return sharedPreferences.getUserUid()
    }

}
