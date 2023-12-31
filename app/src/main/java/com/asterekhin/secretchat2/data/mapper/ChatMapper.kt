package com.asterekhin.secretchat2.data.mapper

import com.asterekhin.secretchat2.data.remote.dto.MessageDto
import com.asterekhin.secretchat2.data.remote.dto.QueueDto
import com.asterekhin.secretchat2.data.remote.dto.UserDto
import com.asterekhin.secretchat2.domain.model.Message
import com.asterekhin.secretchat2.domain.model.Queue
import com.asterekhin.secretchat2.domain.model.User

fun MessageDto.toMessage() = Message(
    id = id,
    receiver = receiver,
    sender = sender,
    message = message,
    timestamp = timestamp,
    isEdited = isEdited
)

fun UserDto.toUser() = User(
    id = id,
    name = name,
    PublicKey = PublicKey,
    token = token
)

fun QueueDto.toQueue() = Queue(
    id = id,
    userId = userId,
    messageId = messageId,
    timestamp = timestamp
)