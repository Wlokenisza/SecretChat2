package com.asterekhin.secretchat2.di

import androidx.lifecycle.ViewModel
import com.asterekhin.secretchat2.presentation.chatList.viewModel.ChatListViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
interface ViewModelModule {

    @ViewModelKay(ChatListViewModel::class)
    @Binds
    @IntoMap
    fun bindsChatListViewModel(vm: ChatListViewModel): ViewModel

}

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKay(val key: KClass<out ViewModel>)

