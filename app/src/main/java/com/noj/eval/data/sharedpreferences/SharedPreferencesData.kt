package com.noj.eval.data.sharedpreferences

import com.noj.eval.model.User

interface SharedPreferencesData {

    var userUid: String

    var userId: Long

    var userName: String

    var userEmail: String

    val user: User

    fun storeUserData(user: User)

}
