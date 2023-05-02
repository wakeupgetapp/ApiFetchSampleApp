package com.wakeupgetapp.apifetchsampleapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.unit.dp
import com.wakeupgetapp.apifetchsampleapp.navigation.AfsaNavHost
import com.wakeupgetapp.apifetchsampleapp.ui.theme.Typography

@Composable
fun AfsaApp() {
    Scaffold(
        topBar = { AfsaTopBar() },
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
    ) {
        Column(Modifier.padding(it)) {
            AfsaNavHost()
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AfsaTopBar() {
    TopAppBar(
        title = {
            Text(
                text = AnnotatedString(
                    stringResource(id = R.string.app_name),
                    spanStyle = SpanStyle(
                        fontFamily = Typography.headlineSmall.fontFamily,
                    )
                ),
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.background)
    )
}