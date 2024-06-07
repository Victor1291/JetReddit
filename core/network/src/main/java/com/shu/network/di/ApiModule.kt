package com.shu.network.di

import android.content.Context
import com.shu.network.ApiPost
import com.shu.network.ApiProfile
import com.shu.network.ApiSubreddits
import com.shu.network.ApiToken
import com.shu.network.dto.More
import com.shu.network.dto.ThingDto
import com.shu.network.dto.commentDto.CommentDto
import com.shu.network.dto.postDto.PostDto
import com.shu.network.interceptor.AuthTokenInterceptor
import com.shu.network.interceptor.AuthTokenInterceptorQualifier
import com.shu.network.interceptor.AuthTokenProvider
import com.shu.network.interceptor.LoggingInterceptorQualifier
import com.shu.network.sharedprefsservice.SharedPrefsService
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideAuthTokenProvider(@ApplicationContext context: Context): AuthTokenProvider =
        AuthTokenProvider(context, SharedPrefsService(context))

    @Provides
    @AuthTokenInterceptorQualifier
    fun provideAuthTokenInterceptor(tokenProvider: AuthTokenProvider): Interceptor =
        AuthTokenInterceptor(tokenProvider)

    @Provides
    @LoggingInterceptorQualifier
    fun provideLoginInterceptor(): Interceptor =
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideRedditClient(
        @LoggingInterceptorQualifier loggingInterceptor: Interceptor,
        @AuthTokenInterceptorQualifier authTokenInterceptor: Interceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(loggingInterceptor)
        .addInterceptor(authTokenInterceptor)
        .followRedirects(true)
        .build()

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(
                PolymorphicJsonAdapterFactory.of(ThingDto::class.java, "kind")
                    .withSubtype(PostDto::class.java, "t3")
                    .withSubtype(CommentDto::class.java, "t1")
                    .withSubtype(More::class.java, "more")
            )
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okhttpClient: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl("https://oauth.reddit.com/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okhttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiToken(retrofit: Retrofit): ApiToken = retrofit.create(ApiToken::class.java)

    @Provides
    @Singleton
    fun provideApiProfile(retrofit: Retrofit): ApiProfile = retrofit.create(ApiProfile::class.java)

    @Provides
    @Singleton
    fun provideApiSubreddits(retrofit: Retrofit): ApiSubreddits =
        retrofit.create(ApiSubreddits::class.java)

    @Provides
    @Singleton
    fun provideApiPost(retrofit: Retrofit): ApiPost = retrofit.create(ApiPost::class.java)
}