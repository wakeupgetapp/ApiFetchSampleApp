package com.wakeupgetapp.apifetchsampleapp.feature.homeScreen.ui.components.popup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.SubcomposeAsyncImage
import com.wakeupgetapp.apifetchsampleapp.data.model.ImageModel
import com.wakeupgetapp.apifetchsampleapp.feature.homeScreen.ui.components.popup.ImageDescription

@Composable
fun ImagePopup(image: ImageModel, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = ShapeDefaults.Large
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            SubcomposeAsyncImage(
                model = image.url,
                contentDescription = image.title,
                loading = { CircularProgressIndicator(modifier = Modifier.wrapContentSize(Alignment.Center)) },
                modifier = Modifier
                    .height(250.dp)
                    .wrapContentHeight()
            )
            ImageDescription(image = image)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
