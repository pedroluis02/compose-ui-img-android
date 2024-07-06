package com.github.pedroluis02.composeimagessample.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.github.pedroluis02.composeimagessample.R
import com.github.pedroluis02.composeimagessample.ui.theme.AndroidComposeImagesTheme

@Composable
fun ComposeApp() {
    AndroidComposeImagesTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                stringResource(id = R.string.app_name),
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}