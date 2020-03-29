package com.appham.mockinizer.demo

import io.mockk.every
import io.mockk.mockk
import io.mockk.verifyOrder
import io.reactivex.Single
import org.junit.Test

class MainViewModelTest {

    @Test
    fun `Should call api On runDemo`() {
        val mockRepository: DemoRepository = mockk()
        every { mockRepository.getMocked() } returns Single.just(
            listOf(Post(id = 0, title = "mocked"))
        )
        every { mockRepository.getMockedError() } returns Single.error(
            Throwable("api error")
        )
        every { mockRepository.getPosts() } returns Single.just(
            listOf(Post(id = 0, title = "test"))
        )

        val viewModel = MainViewModel(mockRepository)
        viewModel.runDemo()

        verifyOrder {
            mockRepository.getMocked()
            mockRepository.getMockedError()
            mockRepository.getPosts()
        }
    }
}
