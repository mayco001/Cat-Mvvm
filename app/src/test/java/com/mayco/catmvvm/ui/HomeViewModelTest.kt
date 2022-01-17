package com.mayco.catmvvm.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mayco.catmvvm.network.response.ApiService
import com.mayco.catmvvm.network.response.response.CatsResponse
import com.mayco.catmvvm.repository.CatsRepository
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@RunWith(MockitoJUnitRunner.Silent::class)
@ExperimentalCoroutinesApi

class HomeViewModelTest {

    private val dispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    private lateinit var viewModel: HomeViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: CatsRepository

    @Mock
    private lateinit var apiService: ApiService

    @Mock
    private lateinit var catObserver: Observer<List<CatsResponse>>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(dispatcher)
        viewModel = HomeViewModel((repository))
    }

    @Test
    fun getNotNull() = TestCoroutineDispatcher().runBlockingTest {
        val catsResponse: List<CatsResponse> = arrayListOf()

        Mockito.`when`(repository.getCats()).thenReturn(Response.success(catsResponse))

        viewModel.returnApi.observeForever(catObserver)
        viewModel.getCats()

        Assert.assertNotNull(viewModel.getCats())
        Assert.assertNotNull(viewModel.returnApi)
    }

    @Test
    fun erro() = TestCoroutineDispatcher().runBlockingTest {

        val catsResponse: List<CatsResponse> = listOf()
        val catsRepository: List<CatsRepository> = listOf()

        Mockito.`when`(repository.getCats()).thenReturn(Response.success(catsResponse))

        viewModel.returnApi.observeForever(catObserver)
        viewModel.getCats()

        verify(repository, times(1)).getCats()
        Assert.assertEquals(viewModel.getCats(), catsRepository)
    }
}
