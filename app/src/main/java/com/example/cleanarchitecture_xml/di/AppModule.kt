package com.example.cleanarchitecture_xml.di

import com.example.cleanarchitecture_xml.data.remote.ApiService
import com.example.cleanarchitecture_xml.data.remote.RetrofitClient
import com.example.cleanarchitecture_xml.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture_xml.domain.repository.UserRepository
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
    fun provideApiService(): ApiService {
        return RetrofitClient().buildService(ApiService::class.java)
    }


    @Provides
    @Singleton
    fun provideCoinRepository(api: ApiService): UserRepository{
        return UserRepositoryImpl(api)
    }

}