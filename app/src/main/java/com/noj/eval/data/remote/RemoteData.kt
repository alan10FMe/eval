package com.noj.eval.data.remote

import com.noj.eval.data.remote.impl.ViewCallBackResponse
import com.noj.eval.model.Group
import com.noj.eval.model.Post
import com.noj.eval.model.Search
import com.noj.eval.model.User

interface RemoteData {

    fun createUser(user: User, callback: ViewCallBackResponse<User>)

    fun getGroupsCreated(userId: Long): List<Group>

    fun getGroupsAccepted(userId: Long): List<Group>

    fun createGroup(userId: Long, group: Group): Group

    fun getGroup(userId: Long, groupId: Long): Group

    fun acceptUser(userId: Long, groupId: Long)

    fun rejectUser(userId: Long, groupId: Long)

    fun searchGroupsByEmail(search: Search): List<Group>

    fun requestAccess(userId: Long, groupId: Long)

    fun createPosts(userId: Long, post: Post): Post

    fun createAnswer(userId: Long, postId: Long, answer: Post): Post

    fun getPosts(userId: Long, groupId: Long): List<Post>

    fun getPost(userId: Long, postId: Long): Post

}
