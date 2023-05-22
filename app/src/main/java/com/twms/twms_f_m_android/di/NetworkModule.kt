package com.twms.twms_f_m_android.di

import com.twms.twms_f_m_android.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() = run {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(Constants().baseURL)
        .client(okHttpClient)
        .build()

    /*@Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): UserListService =
        retrofit.create(UserListService::class.java)

    @Provides
    @Singleton
    fun provideUserDetailsService(retrofit: Retrofit): UserDetailsService =
        retrofit.create(UserDetailsService::class.java)*/

}