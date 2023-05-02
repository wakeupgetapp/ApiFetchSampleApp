package com.wakeupgetapp.apifetchsampleapp.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.wakeupgetapp.apifetchsampleapp.data.local.dao.ImageDao
import com.wakeupgetapp.apifetchsampleapp.data.local.model.ImageEntity
import com.wakeupgetapp.apifetchsampleapp.data.mapper.toEntity
import com.wakeupgetapp.apifetchsampleapp.data.remote.api.ImageApiService
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class ImageRemoteMediator(
    private val imageDao: ImageDao,
    private val imageApiService: ImageApiService
) : RemoteMediator<Int, ImageEntity>() {


    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ImageEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }


            val imagesDto = imageApiService.getImagesList(
                page = loadKey,
                limit = state.config.pageSize
            )

            val imageEntities = imagesDto.map { it.toEntity() }
            if (loadType == LoadType.REFRESH) {
                imageDao.clearAndUpsert(imageEntities)
            } else {
                imageDao.upsertAll(imageEntities)
            }



            MediatorResult.Success(
                endOfPaginationReached = imagesDto.isEmpty()
            )

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }


}