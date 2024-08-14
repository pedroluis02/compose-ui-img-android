package com.github.pedroluis02.composeimagessample.repository

import com.github.pedroluis02.composeimagessample.model.ImageElement

fun interface MediaRepository {
    fun getImages(size: Int): List<ImageElement>
}