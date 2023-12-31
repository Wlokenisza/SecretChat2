package com.asterekhin.secretchat2.domain.repository

import androidx.appcompat.view.menu.ListMenuItemView
import com.asterekhin.secretchat2.domain.model.Message
import com.asterekhin.secretchat2.domain.model.Queue
import com.asterekhin.secretchat2.domain.model.User
import com.asterekhin.secretchat2.domain.util.Response
import kotlinx.coroutines.flow.Flow

interface ChatRepository {

    suspend fun sendMessage(receiver: Long, sender: Long, message: String): Boolean

    suspend fun createUser(userName: String): Boolean

    suspend fun getMessages(oldMessagesId: List<Long>): Response<List<Message>>

    suspend fun getUser(userId: Long): Response<User>
}