package com.mayco.catmvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mayco.catmvvm.network.response.response.CatsResponse
import com.mayco.catmvvm.repository.CatsRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class HomeViewModel(private val repository: CatsRepository) : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    private val _returnApi = MutableLiveData<List<CatsResponse>>()
    val returnApi: LiveData<List<CatsResponse>>
        get() = _returnApi


    fun getCats() {
        launch {

            try {
                val response = repository.getCats()

                if (response.isSuccessful) {
                    _returnApi.postValue(response.body())
                } else {
                    print(response)
                }
            } catch (e: Throwable) {
              print(e)
            }
        }
    }
}