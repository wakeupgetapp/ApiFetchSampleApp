package com.wakeupgetapp.apifetchsampleapp.data.mapper

import com.wakeupgetapp.apifetchsampleapp.data.local.model.ImageEntity
import com.wakeupgetapp.apifetchsampleapp.data.model.ImageModel
import com.wakeupgetapp.apifetchsampleapp.data.remote.model.ImageDto

fun ImageDto.toEntity() = ImageEntity(
    id = id,
    albumId = albumId,
    title = title,
    url = url,
    thumbnailUrl = thumbnailUrl
)

fun ImageEntity.toImageModel() = ImageModel(
    albumId = albumId,
    id = id,
    title = title,
    url = url,
    thumbnailUrl = this.thumbnailUrl
)
