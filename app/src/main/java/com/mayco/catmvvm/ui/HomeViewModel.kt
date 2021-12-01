package com.mayco.catmvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mayco.catmvvm.network.response.response.CatsResponse
import com.mayco.catmvvm.repository.CatsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HomeViewModel(private val repository: CatsRepository) : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    private val _newsList = MutableLiveData<List<CatsResponse>>()
    val newList: LiveData<List<CatsResponse>>
        get() = _newsList

    fun getCats(){
        launch {
            try {
                val response = repository.getCats(15,0)
                    if(response.isNotEmpty()){

                    }
            } catch (e: Exception){

            }
        }
    }
}