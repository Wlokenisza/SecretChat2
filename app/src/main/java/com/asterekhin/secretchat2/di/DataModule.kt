package com.asterekhin.secretchat2.di

import com.asterekhin.secretchat2.data.remote.ChatApi
import com.asterekhin.secretchat2.data.remote.ChatFactory
import com.asterekhin.secretchat2.data.repository.ChatRepositoryImpl
import com.asterekhin.secretchat2.domain.repository.ChatRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface DataModule {

    @Binds
    @Singleton
    fun bindChatRepository(chatRepositoryImpl: ChatRepositoryImpl): ChatRepository

    companion object {
        @Provides
        fun provideChatApi(): ChatApi = ChatFactory.service
    }
}