package com.example.kotlinmvvmrxjava.Common

import com.example.kotlinmvvmrxjava.Network.APIService
import com.example.kotlinmvvmrxjava.Network.RetrofitClient

object Common {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val getAPIService: APIService
        get() = RetrofitClient.getRetrofitClient(BASE_URL).create(APIService::class.java)
}