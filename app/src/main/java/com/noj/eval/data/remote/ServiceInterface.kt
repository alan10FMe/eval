package com.noj.eval.data.remote

import com.noj.eval.model.User

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

private const val PATH_V1 = "/test-app/v1"

interface ServiceInterface {

    @POST("$PATH_V1/users")
    fun createUser(@Body user: User): Call<User>

    @GET("$PATH_V1/users/{userId}")
    fun getUser(@Path("userId") userId: Long): Call<User>

}
