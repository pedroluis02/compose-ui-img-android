package com.github.pedroluis02.composeimagessample

import com.github.pedroluis02.composeimagessample.repository.MediaRepository
import com.github.pedroluis02.composeimagessample.repository.MediaRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
fun interface AppModule {

    @Binds
    fun bindMediaRepository(impl: MediaRepositoryImpl): MediaRepository
}