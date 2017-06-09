package com.noj.eval.model

/**
 * Created by alanflores on 5/31/17.
 */
data class User(
    val id: Int = 0,
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val authenticationType: AuthenticationType = AuthenticationType.GMAIL
)