package com.mayco.catmvvm.repository

import com.mayco.catmvvm.network.response.ApiService
import com.mayco.catmvvm.network.response.response.CatsResponse
import retrofit2.Response

class CatsRepository(private val apiService: ApiService) {
    suspend fun getCats(): Response<List<CatsResponse>> {
        return apiService.getCats()
    }
}
