package com.github.pedroluis02.composeimagessample.ui.image

import androidx.lifecycle.ViewModel
import com.github.pedroluis02.composeimagessample.model.ImageElement
import com.github.pedroluis02.composeimagessample.repository.MediaRepository
import com.github.pedroluis02.composeimagessample.repository.MediaRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ImageListViewModel(
    private val repository: MediaRepository = MediaRepositoryImpl()
) : ViewModel() {
    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    fun fetch() {
        _state.update { currentState ->
            currentState.copy(elements = repository.getImages(size = 30))
        }
    }

    data class UiState(
        val elements: List<ImageElement> = emptyList()
    )
}