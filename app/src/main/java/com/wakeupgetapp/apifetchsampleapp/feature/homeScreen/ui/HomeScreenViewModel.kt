package com.wakeupgetapp.apifetchsampleapp.feature.homeScreen.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.wakeupgetapp.apifetchsampleapp.data.model.ImageModel
import com.wakeupgetapp.apifetchsampleapp.data.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    imageRepository: ImageRepository
) : ViewModel() {

    var imageList =
        imageRepository.getImageList()
            .cachedIn(viewModelScope)

}

