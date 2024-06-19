package com.syafi.suitmediatest.di

import com.syafi.suitmediatest.data.remote.api.ApiConfig
import com.syafi.suitmediatest.data.remote.api.ApiService
import com.syafi.suitmediatest.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi()= ApiConfig.api

    @Provides
    @Singleton
    fun provideRepository(api: ApiService) = Repository(api)
}