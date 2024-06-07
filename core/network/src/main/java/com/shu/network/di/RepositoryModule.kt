package com.shu.network.di

import com.shu.auth.domain.AuthRepository
import com.shu.network.repository.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

//    @Singleton
//    @Binds
//    abstract fun bindProfileRemoteRepository(
//        profileRemoteRepository: ProfileRemoteRepositoryImpl
//    ): ProfileRemoteRepository
//
//    @Singleton
//    @Binds
//    abstract fun bindSubredditsRemoteRepository(
//        subredditsRemoteRepository: SubredditsRemoteRepositoryImpl
//    ): SubredditsRemoteRepository
}

