package com.ys.essential.network

import com.ys.essential.network.dto.TestData
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("/api/test")
    fun getTest(): Single<TestData.TestDataRes>
}