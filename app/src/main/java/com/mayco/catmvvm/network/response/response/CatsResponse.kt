package com.mayco.catmvvm.network.response.response

import com.squareup.moshi.Json

data class CatsResponse(
    @Json(name = "id")
    var id: String?,

    @Json(name = "url")
    var url: String?
)