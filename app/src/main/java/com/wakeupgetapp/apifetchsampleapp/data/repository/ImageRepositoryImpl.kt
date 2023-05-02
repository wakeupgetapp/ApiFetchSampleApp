package com.wakeupgetapp.apifetchsampleapp.data.repository

import androidx.paging.*
import com.wakeupgetapp.apifetchsampleapp.data.local.model.ImageEntity
import com.wakeupgetapp.apifetchsampleapp.data.mapper.toImageModel
import com.wakeupgetapp.apifetchsampleapp.data.model.ImageModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class ImageRepositoryImpl @Inject constructor(
    private val imagePager: Pager<Int, ImageEntity>
) : ImageRepository {
    override fun getImageList(): Flow<PagingData<ImageModel>> =
         imagePager.flow.map { it ->
            it.map { it.toImageModel() }
        }
}

