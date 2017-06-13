package com.noj.eval.model

import java.io.Serializable

data class User(
    val id: Long = 0,
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val authenticationType: AuthenticationType = AuthenticationType.GMAIL
) : Serializable
