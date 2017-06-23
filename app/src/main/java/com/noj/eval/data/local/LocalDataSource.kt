package com.noj.eval.data.local

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject internal constructor(val context: Context) : LocalData {

}
