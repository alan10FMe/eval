package com.noj.eval.data.sharedpreferences

import android.preference.PreferenceManager
import com.noj.eval.model.User

interface SharedPreferencesData {

    var user: User

    var userUid: String

}
