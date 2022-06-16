package com.example.coroutinesample.Forth

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UsersInstance {
    private  val baseUrl="https://jsonplaceholder.typicode.com/"
    private val commentUrl="https://jsonplaceholder.typicode.com/"
    private val usersInterface:UsersInterface?=null
    fun getinstance():UsersInterface{
       return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build().create(
           UsersInterface::class.java)

        return usersInterface!!
    }

}