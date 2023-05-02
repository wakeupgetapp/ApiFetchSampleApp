package com.wakeupgetapp.apifetchsampleapp.feature.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import com.wakeupgetapp.apifetchsampleapp.feature.homeScreen.ui.HomeScreen
import com.wakeupgetapp.apifetchsampleapp.feature.homeScreen.ui.HomeScreenViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.wakeupgetapp.apifetchsampleapp.R


@Composable
fun HomeRoute(
    navController: NavHostController,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    val imageModels = viewModel.imageList.collectAsLazyPagingItems()

    when (imageModels.loadState.refresh) {
        is LoadState.Error -> ErrorPage(
            error = (imageModels.loadState.refresh as LoadState.Error).error,
            onClick = { imageModels.refresh() })

        is LoadState.Loading -> Loading()
        is LoadState.NotLoading ->
            HomeScreen(
                imageModels = imageModels
            )
    }
}


@Composable
fun ErrorPage(error: Throwable, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.unable_to_fetch_data),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { onClick() }) {
                Text(text = stringResource(R.string.try_again))
            }
        }

        error.message?.let {
            Text(
                text = it,
                modifier = Modifier.align(Alignment.BottomCenter),
                textAlign = TextAlign.Center
            )
        }
    }

}

@Composable
fun Loading() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}