package com.example.coroutinesample.Forth

import com.example.coroutinesample.Forth.SecondApi.CommentSecond
import retrofit2.Response
import retrofit2.http.GET

interface UsersInterface {
    @GET("users")
    suspend fun getUsersData() :Response<Usersdata>

    @GET("comments")
    suspend fun getCommentsData() :Response<CommentSecond>
}