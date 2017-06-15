package com.noj.eval.data.sharedpreferences

import android.content.Context
import android.preference.PreferenceManager
import com.noj.eval.data.EvalDataSource
import com.noj.eval.model.Group
import com.noj.eval.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesDataSource @Inject internal constructor(val context: Context) : SharedPreferencesData {

    val USER_UID = "user_uid"

    override var user: User
        get() = User(id = 1, name = "Alan Flores", email = "alan10fm@gmail.com")
        set(value) {}

    override var userUid: String
        get() = PreferenceManager.getDefaultSharedPreferences(context).getString(USER_UID, "")
        set(value) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(USER_UID, value).apply()
        }

}
