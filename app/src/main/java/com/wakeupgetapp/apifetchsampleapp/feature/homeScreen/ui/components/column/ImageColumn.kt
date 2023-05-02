package com.wakeupgetapp.apifetchsampleapp.feature.homeScreen.ui.components.column

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.wakeupgetapp.apifetchsampleapp.data.model.ImageModel
import com.wakeupgetapp.apifetchsampleapp.feature.homeScreen.ui.components.ImageItem

@Composable
fun ImageColumn(
    imageModels: LazyPagingItems<ImageModel>,
    onImageItemClick: (ImageModel) -> Unit,
    appendState: LoadState
) {
    LazyColumn {
        itemsIndexed(items = imageModels, key = { _, item -> item.id }) { index, item ->
            if (item != null) {
                if (index == 0) {
                    ImageHeader(albumId = item.albumId)
                }
                if (index > 0 &&
                    imageModels.peek(index - 1) != null &&
                    imageModels.peek(index - 1)!!.albumId < item.albumId
                ) {
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .background(
                                color = MaterialTheme.colorScheme.primaryContainer,
                                RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                            )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ImageHeader(albumId = item.albumId)
                }
                ImageItem(item, onImageItemClick)
            }
        }
        item {
            ImageFooter(appendState) { imageModels.retry() }
        }

    }
}