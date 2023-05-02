package com.wakeupgetapp.apifetchsampleapp.feature.homeScreen.ui.components.popup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.SubcomposeAsyncImage
import com.wakeupgetapp.apifetchsampleapp.R
import com.wakeupgetapp.apifetchsampleapp.data.model.ImageModel

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
                error = { ImageErrorText(text = stringResource(id = R.string.cannot_load_image)) },
                modifier = Modifier
                    .height(250.dp)
                    .wrapContentHeight()
            )
            ImageDescription(image = image)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Composable
private fun ImageErrorText(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .wrapContentSize(Alignment.Center),
        textAlign = TextAlign.Center
    )
}
