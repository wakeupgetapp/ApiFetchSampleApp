package com.wakeupgetapp.apifetchsampleapp.feature.homeScreen.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.wakeupgetapp.apifetchsampleapp.data.model.ImageModel

@Composable
fun ImageItem(image: ImageModel, onImageItemClick: (ImageModel) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
            .clickable { onImageItemClick(image) },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SubcomposeAsyncImage(
            model = image.thumbnailUrl,
            contentDescription = image.title,
            loading = { CircularProgressIndicator(modifier = Modifier.wrapContentSize(Alignment.Center)) },
            modifier = Modifier
                .height(150.dp),
        )
        Text(
            text = image.title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Center
        )
    }
}
