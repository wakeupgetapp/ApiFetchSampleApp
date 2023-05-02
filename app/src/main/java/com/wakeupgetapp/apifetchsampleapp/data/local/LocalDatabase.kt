package com.wakeupgetapp.apifetchsampleapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wakeupgetapp.apifetchsampleapp.data.local.dao.ImageDao
import com.wakeupgetapp.apifetchsampleapp.data.local.model.ImageEntity

@Database(
    entities = [ImageEntity::class],
    version = 1
)
abstract class LocalDatabase: RoomDatabase() {

    abstract val imageDao: ImageDao
}