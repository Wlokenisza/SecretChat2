package com.asterekhin.secretchat2.data.remote

import com.asterekhin.secretchat2.data.remote.dto.MessageDto
import com.asterekhin.secretchat2.data.remote.dto.QueueDto
import com.asterekhin.secretchat2.data.remote.dto.UserDto
import com.asterekhin.secretchat2.data.remote.postBody.MessageBody
import com.asterekhin.secretchat2.data.remote.postBody.UserBody
import retrofit2.Call
import retrofit2.http.*


interface ChatApi {

    @POST("users")
    fun createUser(@Body postUserBody: UserBody): Call<UserDto>

    @POST("messages")
    fun sendMessage(@Body postMessageBody: MessageBody): Call<MessageDto>

    @GET("messages/{id}")
    suspend fun getMessage(@Path("id") messageId: Long, @Query("token") token: String): MessageDto

    @GET("quaue/{id}")
    suspend fun getQueue(@Path("id") userId: Long, @Query("token") token: String): List<QueueDto>

    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Long): UserDto
}