package com.noj.eval.model

import java.io.Serializable

data class User(
    val id: Long? = null,
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val authenticationType: Int = AuthenticationType.GMAIL.type
) : Serializable
