package com.wakeupgetapp.apifetchsampleapp.di

import com.wakeupgetapp.apifetchsampleapp.data.repository.ImageRepository
import com.wakeupgetapp.apifetchsampleapp.data.repository.ImageRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsImageRepository(
        imageRepository: ImageRepositoryImpl
    ): ImageRepository

}