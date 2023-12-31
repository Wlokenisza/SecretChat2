package com.asterekhin.secretchat2.di

import android.content.Context
import com.asterekhin.secretchat2.presentation.MainActivity
import com.asterekhin.secretchat2.presentation.chatList.ChatListFragment
import com.asterekhin.secretchat2.presentation.registration.RegistrationFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [DataModule::class, ViewModelModule::class, DomainModule::class])
interface ChatComponent {


    fun inject(fragment: ChatListFragment)
    fun inject(fragment: RegistrationFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context) : ChatComponent
    }
}