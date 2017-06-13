package com.noj.eval.data.sharedpreferences

import android.content.Context
import android.preference.PreferenceManager
import com.noj.eval.data.EvalDataSource
import com.noj.eval.data.SharedPreferences
import com.noj.eval.model.Group
import com.noj.eval.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@SharedPreferences
class SharedPreferencesDataSource @Inject internal constructor(val context: Context) : EvalDataSource {

    val USER_UID = "user_uid"

    override var user: User
        get() = TODO("not implemented")
        set(value) {}

    override var userUid: String
        get() = PreferenceManager.getDefaultSharedPreferences(context).getString(USER_UID, "")
        set(value) {
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(USER_UID, value).apply()
        }

    override var groupsCreated: List<Group>
        get() = TODO("not implemented")
        set(value) {}

    override var groupsAccepted: List<Group>
        get() = TODO("not implemented")
        set(value) {}

    override fun createGroup(group: Group): Group {
        TODO("not implemented")
    }

}
