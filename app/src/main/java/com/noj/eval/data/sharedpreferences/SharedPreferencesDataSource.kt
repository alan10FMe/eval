package com.noj.eval.data.sharedpreferences

import android.content.Context
import android.preference.PreferenceManager
import com.noj.eval.data.EvalDataSource
import com.noj.eval.data.SharedPreferences
import com.noj.eval.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@SharedPreferences
class SharedPreferencesDataSource @Inject internal constructor(val context: Context) : EvalDataSource {

    val USER_UID = "user_uid"

    override fun saveUser(user: User) {
        TODO("not implemented")
    }

    override fun saveUserUid(uid: String) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(USER_UID, uid).commit()

    }

    override fun getUserUid(): String {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(USER_UID, "")
    }

}