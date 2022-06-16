package com.example.coroutinesample.SecondActivity.network2ndAct

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CommentInstance {
    val baseUrl="https://jsonplaceholder.typicode.com/"
    private val commentsService :CommentService?=null
    fun getCommentsService() :CommentService{
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
            .create(CommentService::class.java)

        return commentsService!!
    }
}