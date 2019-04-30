package com.ys.essential.di

import android.content.Context
import com.ys.essential.storage.SharedPreferenceStorageImpl
import com.ys.essential.storage.SharedPreferenceStorage
import com.ys.essential.storage.Storage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class StorageModule {
    @Provides
    @Singleton
    fun provideSharedPreferenceStorage(context: Context): SharedPreferenceStorage {
        return SharedPreferenceStorageImpl(context)
    }

    @Provides
    @Singleton
    fun provideStorage(sharedPreferenceStorage: SharedPreferenceStorage): Storage {
        return sharedPreferenceStorage
    }
}