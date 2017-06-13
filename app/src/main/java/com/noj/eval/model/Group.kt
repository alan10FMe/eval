package com.noj.eval.model

import java.io.Serializable

data class Group(
    val id: Long = 0,
    val name: String = "",
    val creator: User = User(),
    val requesters: List<User> = emptyList(),
    val participants: List<User> = emptyList()
) : Serializable
