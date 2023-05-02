package com.wakeupgetapp.apifetchsampleapp.feature.homeScreen.ui.components.column

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import com.wakeupgetapp.apifetchsampleapp.R

@Composable
fun ImageFooter(appendState: LoadState, retryLoad: () -> Unit) {
    when (appendState) {
        is LoadState.Loading ->
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                CircularProgressIndicator()
            }

        is LoadState.Error -> {
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        RoundedCornerShape(size = 16.dp)
                    ), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImageFooterText(text = stringResource(id = R.string.error_occurred_try_again))
                Button(onClick = { retryLoad() }) {
                    Text(text = stringResource(id = R.string.retry))
                }
            }
        }

        else -> {}
    }
}

@Composable
private fun ImageFooterText(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        textAlign = TextAlign.Center
    )
}