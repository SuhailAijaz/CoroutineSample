package com.example.coroutinesample.SecondActivity.network2ndAct

import retrofit2.Response
import retrofit2.http.GET

interface CommentService {
    @GET("comments")
    suspend fun getData() :Response<CommentsDataClass>
}