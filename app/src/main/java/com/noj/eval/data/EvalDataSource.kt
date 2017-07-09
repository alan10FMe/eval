package com.noj.eval.data

import com.noj.eval.model.Group
import com.noj.eval.model.Post
import com.noj.eval.model.Search
import com.noj.eval.model.User

interface EvalDataSource {

    val groupsCreated: MutableList<Group>

    val groupsAccepted: MutableList<Group>

    fun createUser(user: User)

    fun createGroup(group: Group)

    fun getGroup(groupId: Long): Group

    fun acceptUser(userId: Long, groupId: Long)

    fun rejectUser(userId: Long, groupId: Long)

    fun searchGroupsByEmail(search: Search): List<Group>

    fun requestAccess(groupId: Long)

    fun createPosts(post: Post): Post

    fun createAnswer(postId: Long, answer: Post): Post

    fun getPosts(groupId: Long): List<Post>

    fun getPost(postId: Long): Post

}
