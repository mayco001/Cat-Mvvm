package com.mayco.catmvvm.network.response.response

import com.squareup.moshi.Json

data class CatsResponse(
    @Json(name = "id")
    var id: String?,

    @Json(name = "created_at")
    var created_at: String?,

//    @Json(name = "tags")
//    var tags: List<String>?
)
