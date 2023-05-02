package com.wakeupgetapp.apifetchsampleapp.data.local.dao

import androidx.paging.LoadType
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.wakeupgetapp.apifetchsampleapp.data.local.model.ImageEntity

@Dao
interface ImageDao {

    @Upsert
    suspend fun upsertAll(images: List<ImageEntity>)

    @Query("SELECT * FROM image_entity")
    fun pagingSource(): PagingSource<Int, ImageEntity>

    @Query("DELETE FROM image_entity")
    suspend fun clearAll()

    @Transaction
    suspend fun clearAndUpsert(images: List<ImageEntity>){
        clearAll()
        upsertAll(images)
    }
}