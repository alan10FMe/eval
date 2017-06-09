package com.noj.eval.data.local

import android.content.Context
import com.noj.eval.data.EvalDataSource
import com.noj.eval.data.Local
import com.noj.eval.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Local
class LocalDataSource @Inject internal constructor(val context: Context) : EvalDataSource {

    override fun saveUser(user: User) {
        TODO("SAVE LOCAL DATABASE")
    }

    override fun saveUserUid(uid: String) {
        TODO("not implemented")
    }

    override fun getUserUid(): String {
        TODO("not implemented")
    }

}