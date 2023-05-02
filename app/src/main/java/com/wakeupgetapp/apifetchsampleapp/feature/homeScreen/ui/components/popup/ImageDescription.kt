package com.wakeupgetapp.apifetchsampleapp.feature.homeScreen.ui.components.popup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.wakeupgetapp.apifetchsampleapp.R
import com.wakeupgetapp.apifetchsampleapp.data.model.ImageModel

@Composable
fun ImageDescription(image: ImageModel) {
    ImageDescriptionText(text = image.title)
    Spacer(modifier = Modifier.height(4.dp))
    ImageDescriptionText(
        key = "${stringResource(id = R.string.album)}: ",
        value = "${image.albumId}"
    )
    ImageDescriptionText(key = "${stringResource(id = R.string.id)}: ", value = "${image.id}")

}

@Composable
private fun ImageDescriptionText(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun ImageDescriptionText(key: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(key)
        Text(value)
    }
}