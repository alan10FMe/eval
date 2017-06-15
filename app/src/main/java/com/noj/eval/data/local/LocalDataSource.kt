package com.noj.eval.data.local

import android.content.Context
import com.noj.eval.data.EvalDataSource
import com.noj.eval.model.Group
import com.noj.eval.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject internal constructor(val context: Context) : LocalData {

}
