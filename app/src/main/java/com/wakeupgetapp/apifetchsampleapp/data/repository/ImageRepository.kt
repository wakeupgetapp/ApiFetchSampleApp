package com.wakeupgetapp.apifetchsampleapp.data.repository

import androidx.paging.PagingData
import com.wakeupgetapp.apifetchsampleapp.data.model.ImageModel
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    fun getImageList(): Flow<PagingData<ImageModel>>
}