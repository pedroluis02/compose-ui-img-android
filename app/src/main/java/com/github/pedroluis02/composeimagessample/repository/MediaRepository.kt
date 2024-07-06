package com.github.pedroluis02.composeimagessample.repository

import com.github.pedroluis02.composeimagessample.model.ImageElement

object MediaRepository {

    fun getImages(size: Int = 10) = (1..size).map {
        ImageElement(
            id = it,
            url = "https://loremflickr.com/400/400/peope?lock=$it"
        )
    }
}