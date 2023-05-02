package com.wakeupgetapp.apifetchsampleapp.feature.homeScreen.ui


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.paging.compose.LazyPagingItems
import com.wakeupgetapp.apifetchsampleapp.data.model.ImageModel
import com.wakeupgetapp.apifetchsampleapp.feature.homeScreen.ui.components.column.ImageColumn
import com.wakeupgetapp.apifetchsampleapp.feature.homeScreen.ui.components.popup.ImagePopup


@Composable
fun HomeScreen(imageModels: LazyPagingItems<ImageModel>) {

    val appendState = imageModels.loadState.append

    var showDialog by remember { mutableStateOf(false) }
    var selectedImageModel by remember { mutableStateOf<ImageModel?>(null) }

    val onImageItemClick: (ImageModel) -> Unit = { imageModel ->
        selectedImageModel = imageModel
        showDialog = true
    }

    if (showDialog && (selectedImageModel != null)) {
        ImagePopup(image = selectedImageModel!!, onDismiss = { showDialog = false })
    }

    ImageColumn(imageModels, onImageItemClick, appendState)

}

