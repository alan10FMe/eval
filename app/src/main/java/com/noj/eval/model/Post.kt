package com.noj.eval.model

import java.io.Serializable

data class Post(
        val id: Long = 0,
        val title: String = "",
        val message: String = "",
        val createdDate: String = "",
        val creator: User = User(),
        val readers: List<User> = emptyList(),
        val answers: List<Post> = emptyList()
) : Serializable
