package com.example.coroutinesample.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {
    val baseUrl="https://jsonplaceholder.typicode.com/"
    private val retroservice:RetroService?=null
    fun getService() : RetroService{
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
            .create(RetroService::class.java)
        return retroservice!!
    }
}