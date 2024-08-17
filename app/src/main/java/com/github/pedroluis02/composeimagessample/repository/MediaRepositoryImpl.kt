package com.github.pedroluis02.composeimagessample.repository

import com.github.pedroluis02.composeimagessample.model.ImageElement
import javax.inject.Inject

class MediaRepositoryImpl @Inject constructor() : MediaRepository {

    override fun getImages(size: Int) = (1..size).map {
        ImageElement(
            id = it,
            url = "https://loremflickr.com/400/400/peope?lock=$it"
        )
    }
}