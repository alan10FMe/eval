package com.noj.eval.data.local

import android.content.Context
import com.noj.eval.data.EvalDataSource
import com.noj.eval.data.Local
import com.noj.eval.model.Group
import com.noj.eval.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Local
class LocalDataSource @Inject internal constructor(val context: Context) : EvalDataSource {

    override var user: User
        get() = TODO("not implemented")
        set(value) {}

    override var userUid: String
        get() = TODO("not implemented")
        set(value) {}

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
