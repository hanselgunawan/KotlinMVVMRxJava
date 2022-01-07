package com.example.kotlinmvvmrxjava.Network

import com.example.kotlinmvvmrxjava.Model.PostModel
import io.reactivex.Observable
import retrofit2.http.GET

interface APIService {
    @GET("posts")
    fun getPosts(): Observable<MutableList<PostModel>>
}