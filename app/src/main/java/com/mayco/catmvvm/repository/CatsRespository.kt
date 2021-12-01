package com.mayco.catmvvm.repository

import com.mayco.catmvvm.network.response.ApiService


class CatsRepository(private val apiService: ApiService) {
    suspend fun getCats(limit: Int, start: Int) = apiService.getCats(limit, start).await()


}