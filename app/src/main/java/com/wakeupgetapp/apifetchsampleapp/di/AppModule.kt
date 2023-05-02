package com.wakeupgetapp.apifetchsampleapp.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.wakeupgetapp.apifetchsampleapp.BuildConfig
import com.wakeupgetapp.apifetchsampleapp.util.Constants
import com.wakeupgetapp.apifetchsampleapp.data.remote.ImageRemoteMediator
import com.wakeupgetapp.apifetchsampleapp.data.local.LocalDatabase
import com.wakeupgetapp.apifetchsampleapp.data.local.dao.ImageDao
import com.wakeupgetapp.apifetchsampleapp.data.local.model.ImageEntity
import com.wakeupgetapp.apifetchsampleapp.data.remote.api.ImageApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ImageApiService =
        retrofit.create(ImageApiService::class.java)

    @Provides
    @Singleton
    fun provideLocalDatabase(@ApplicationContext context: Context): LocalDatabase {
        return Room.databaseBuilder(
            context,
            LocalDatabase::class.java,
            "images.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideImageDao(localDatabase: LocalDatabase): ImageDao = localDatabase.imageDao

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideImagePager(imageDao: ImageDao, imageApiService: ImageApiService)
            : Pager<Int, ImageEntity> =
        Pager(
            config = PagingConfig(
                pageSize = Constants.PAGE_SIZE,
                enablePlaceholders = true
            ),
            remoteMediator = ImageRemoteMediator(
                imageDao = imageDao,
                imageApiService = imageApiService
            ),
            pagingSourceFactory = {
                imageDao.pagingSource()
            }
        )


}