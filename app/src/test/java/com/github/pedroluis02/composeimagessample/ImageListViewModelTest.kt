package com.github.pedroluis02.composeimagessample

import app.cash.turbine.test
import com.github.pedroluis02.composeimagessample.model.ImageElement
import com.github.pedroluis02.composeimagessample.repository.MediaRepository
import com.github.pedroluis02.composeimagessample.ui.image.ImageListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ImageListViewModelTest {

    private lateinit var viewModel: ImageListViewModel
    private val repository = MyMediaRepository()

    @Before
    fun onBefore() {
        viewModel = ImageListViewModel(repository)
    }

    @Test
    fun `Given a view model When fetching Then returning values`() = runTest {
        val dispatcher = UnconfinedTestDispatcher(testScheduler)
        val results = mutableListOf<ImageListViewModel.UiState>()
        backgroundScope.launch(dispatcher) {
            viewModel.state.toList(results)
        }

        viewModel.fetch()

        assertEquals(true, results[0].elements.isEmpty())
        assertEquals(ImageListViewModel.DEFAULT_ELEMENTS_SIZE, results[1].elements.size)
    }

    @Test
    fun testWithTurbine() = runTest {
        viewModel.state.test {
            viewModel.fetch()

            assertEquals(
                ImageListViewModel.DEFAULT_ELEMENTS_SIZE,
                expectMostRecentItem().elements.size,
            )
        }
    }

    inner class MyMediaRepository : MediaRepository {
        override fun getImages(size: Int): List<ImageElement> {
            return (1..size).map { ImageElement(it, "example.com/image-$it") }.toList()
        }
    }
}