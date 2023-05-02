package com.wakeupgetapp.apifetchsampleapp.data.remote.api

import com.wakeupgetapp.apifetchsampleapp.data.remote.model.ImageDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApiService{

    @GET("photos")
    suspend fun getImagesList(
        @Query("_page") page: Int,
        @Query("_limit") limit: Int
    ): List<ImageDto>
}