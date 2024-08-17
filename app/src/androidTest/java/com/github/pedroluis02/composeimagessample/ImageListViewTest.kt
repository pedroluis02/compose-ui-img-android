package com.github.pedroluis02.composeimagessample

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import com.github.pedroluis02.composeimagessample.model.ImageElement
import com.github.pedroluis02.composeimagessample.repository.MediaRepository
import com.github.pedroluis02.composeimagessample.ui.image.ImageListView
import com.github.pedroluis02.composeimagessample.ui.image.ImageListViewModel
import com.github.pedroluis02.composeimagessample.ui.theme.AndroidComposeImagesTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ImageListViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var viewModel: ImageListViewModel

    @Before
    fun onBefore() {
        viewModel = ImageListViewModel(repository = MyMediaRepository())
    }

    @Test
    fun shouldShowElementsWithViewModel() {
        composeTestRule.setContent {
            AndroidComposeImagesTheme {
                ImageListView(viewModel = viewModel)
            }
        }

        composeTestRule.onNodeWithTag("listView")
            .assertExists()

        val firstElement = viewModel.state.value.elements.first()
        composeTestRule.onNodeWithContentDescription(firstElement.url).assertExists()
    }

    inner class MyMediaRepository : MediaRepository {
        override fun getImages(size: Int): List<ImageElement> {
            return (1..size).map { ImageElement(it, "example.com/image-$it") }.toList()
        }
    }
}