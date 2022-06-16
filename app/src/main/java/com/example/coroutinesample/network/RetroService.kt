package com.example.coroutinesample.network

import com.example.coroutinesample.PostsData
import com.example.coroutinesample.PostsDataItem
import retrofit2.Response
import retrofit2.http.GET

interface RetroService {
    @GET("posts")
    suspend fun getData(): Response<PostsData>
}