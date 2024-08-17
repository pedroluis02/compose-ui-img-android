package com.github.pedroluis02.composeimagessample.ui.image

import androidx.lifecycle.ViewModel
import com.github.pedroluis02.composeimagessample.model.ImageElement
import com.github.pedroluis02.composeimagessample.repository.MediaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(
    val repository: MediaRepository
) : ViewModel() {

    companion object {
        const val DEFAULT_ELEMENTS_SIZE = 30
    }

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    fun fetch() {
        _state.update { currentState ->
            currentState.copy(elements = repository.getImages(size = DEFAULT_ELEMENTS_SIZE))
        }
    }

    data class UiState(
        val elements: List<ImageElement> = emptyList()
    )
}