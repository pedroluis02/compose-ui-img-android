package com.github.pedroluis02.composeimagessample.ui


import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.github.pedroluis02.composeimagessample.model.ImageElement

@Composable
fun ImageListView(elements: List<ImageElement>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items(elements) { element ->
            Card {
                AsyncImage(
                    model = element.url,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}