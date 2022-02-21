package com.mayco.catmvvm.network.response

import com.mayco.catmvvm.network.response.response.CatsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/cats?tags=cute")
    suspend fun getCats(): Response<List<CatsResponse>>
}
