package com.noj.eval.data

import com.noj.eval.data.local.LocalData
import com.noj.eval.data.remote.RemoteData
import com.noj.eval.data.remote.impl.ViewCallBackResponse
import com.noj.eval.data.sharedpreferences.SharedPreferencesData
import com.noj.eval.model.Group
import com.noj.eval.model.Post
import com.noj.eval.model.Search
import com.noj.eval.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EvalRepository @Inject internal constructor(
        private val remoteDataSource: RemoteData,
        private val localRemoteDataSource: LocalData,
        private val sharedPreferences: SharedPreferencesData
) : EvalDataSource {

    override val user: User
        get() = sharedPreferences.user

    override val groupsCreated: MutableList<Group> by lazy {
        remoteDataSource.getGroupsCreated(sharedPreferences.userId).toMutableList()
    }

    override val groupsAccepted: MutableList<Group> by lazy {
        remoteDataSource.getGroupsAccepted(sharedPreferences.userId).toMutableList()
    }

    override fun createUser(user: User, callback: ViewCallBackResponse<User>) {
        remoteDataSource.createUser(user, callback)
    }

    override fun storeUserData(user: User) {
        sharedPreferences.storeUserData(user)
    }

    override fun createGroup(group: Group) {
        val groupCreated = remoteDataSource.createGroup(
                sharedPreferences.userId,
                group.copy(creator = sharedPreferences.user))
        groupsCreated.add(groupCreated)
        groupsCreated.sortBy { it.name }
    }

    override fun getGroup(groupId: Long): Group {
        return remoteDataSource.getGroup(sharedPreferences.userId, groupId)
    }

    override fun acceptUser(userId: Long, groupId: Long) {
        remoteDataSource.acceptUser(userId, groupId)
    }

    override fun rejectUser(userId: Long, groupId: Long) {
        remoteDataSource.rejectUser(userId, groupId)
    }

    override fun searchGroupsByEmail(search: Search): List<Group> {
        return remoteDataSource.searchGroupsByEmail(search)
    }

    override fun requestAccess(groupId: Long) {
        remoteDataSource.requestAccess(sharedPreferences.userId, groupId)
    }

    override fun createPosts(post: Post): Post {
        return remoteDataSource.createPosts(sharedPreferences.userId, post)
    }

    override fun createAnswer(postId: Long, answer: Post): Post {
        return remoteDataSource.createAnswer(sharedPreferences.userId, postId, answer)
    }

    override fun getPosts(groupId: Long): List<Post> {
        return remoteDataSource.getPosts(sharedPreferences.userId, groupId)
    }

    override fun getPost(postId: Long): Post {
        return remoteDataSource.getPost(sharedPreferences.userId, postId)
    }

}
