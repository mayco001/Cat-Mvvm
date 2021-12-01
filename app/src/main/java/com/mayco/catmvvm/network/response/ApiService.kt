package com.mayco.catmvvm.network.response

import com.mayco.catmvvm.network.response.response.CatsResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("https://cataas.com/")
    fun getCats(
        @Query("_limit") limit: Int,
        @Query("start") start: Int
    ): Deferred<List<CatsResponse>>
}