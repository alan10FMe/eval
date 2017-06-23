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

    private val KEY_USER_UID = "user_uid"
    private val KEY_USER_ID = "user_id"
    private val KEY_USER_NAME = "user_name"
    private val KEY_USER_EMAIL = "user_email"

    override var userUid: String
        get() = PreferenceManager.getDefaultSharedPreferences(context).getString(KEY_USER_UID, "")
        set(value) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(KEY_USER_UID, value).apply()
        }

    override var userId: Long
        get() = PreferenceManager.getDefaultSharedPreferences(context).getLong(KEY_USER_ID, 0)
        set(value) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putLong(KEY_USER_ID, value).apply()
        }

    override var userName: String
        get() = PreferenceManager.getDefaultSharedPreferences(context).getString(KEY_USER_NAME, "")
        set(value) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(KEY_USER_NAME, value).apply()
        }

    override var userEmail: String
        get() = PreferenceManager.getDefaultSharedPreferences(context).getString(KEY_USER_EMAIL, "")
        set(value) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(KEY_USER_EMAIL, value).apply()
        }

    override fun storeUserData(user: User) {
        userUid = user.uid
        userId = user.id
        userName = userName
        userEmail = userEmail
    }

}
