package com.noj.eval.data.remote

import com.noj.eval.model.Group
import com.noj.eval.model.Post
import com.noj.eval.model.Search
import com.noj.eval.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject internal constructor() : RemoteData {

    override fun createUser(user: User): User {
        return User()
    }

    override fun getGroupsCreated(userId: Long): List<Group> {
        return emptyList()
    }

    override fun getGroupsAccepted(userId: Long): List<Group> {
        return emptyList()
    }

    override fun createGroup(userId: Long, group: Group): Group {
        return Group()
    }

    override fun getGroup(userId: Long, groupId: Long): Group {
        return Group()
    }

    override fun acceptUser(userId: Long, groupId: Long) {

    }

    override fun rejectUser(userId: Long, groupId: Long) {

    }

    override fun searchGroupsByEmail(search: Search): List<Group> {
        return emptyList()
    }

    override fun requestAccess(userId: Long, groupId: Long) {

    }

    override fun createPosts(userId: Long, post: Post): Post {
        return Post()
    }

    override fun createAnswer(userId: Long, postId: Long, answer: Post): Post {
        return Post()
    }

    override fun getPosts(userId: Long, groupId: Long): List<Post> {
        return emptyList()
    }

    override fun getPost(userId: Long, postId: Long): Post {
        return Post()
    }

}
