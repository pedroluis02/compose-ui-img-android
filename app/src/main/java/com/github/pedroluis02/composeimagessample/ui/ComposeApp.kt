package com.github.pedroluis02.composeimagessample.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.github.pedroluis02.composeimagessample.R
import com.github.pedroluis02.composeimagessample.ui.theme.AndroidComposeImagesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeApp() {
    AndroidComposeImagesTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(id = R.string.title)) }
                )
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Text(
                stringResource(id = R.string.app_name),
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}