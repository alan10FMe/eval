package com.noj.eval.model

import java.io.Serializable

data class Search(
    val filter: String = "email",
    val value: String = ""
) : Serializable
