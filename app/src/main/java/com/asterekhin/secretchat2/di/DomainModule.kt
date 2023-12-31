package com.asterekhin.secretchat2.di

import android.content.Context
import com.asterekhin.secretchat2.domain.util.SharedPreferences
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return SharedPreferences(context)
    }
}