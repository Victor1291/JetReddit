package com.shu.network.di

import com.shu.auth.domain.StorageService
import com.shu.network.sharedprefsservice.SharedPrefsService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageServiceModule  {

    @Singleton
    @Binds
    abstract fun bindStorageService(
        storageService: SharedPrefsService
    ): StorageService
}