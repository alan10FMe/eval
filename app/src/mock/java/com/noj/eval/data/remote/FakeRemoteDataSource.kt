package com.noj.eval.data.remote

import android.util.Log
import com.noj.eval.data.EvalDataSource
import com.noj.eval.data.Remote
import com.noj.eval.model.User
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Remote
class FakeRemoteDataSource @Inject internal constructor() : EvalDataSource, AnkoLogger {

    override fun saveUser(user: User) {
        info("User saved")
    }

    override fun saveUserUid(uid: String) {
        TODO("not implemented")
    }

    override fun getUserUid(): String {
        TODO("not implemented")
    }

}