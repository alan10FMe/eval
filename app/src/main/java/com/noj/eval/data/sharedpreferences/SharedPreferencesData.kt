package com.noj.eval.data.sharedpreferences

import android.preference.PreferenceManager
import com.noj.eval.model.User

interface SharedPreferencesData {

    var userUid: String

    var userId: Long

    var userName: String

    var userEmail: String

    fun storeUserData(user: User)

}
