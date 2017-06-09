package com.noj.eval.data

import com.noj.eval.model.User

interface EvalDataSource {

    fun saveUser(user: User)

    fun saveUserUid(uid: String)

    fun getUserUid(): String

}