package com.example.testapp.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val BASEURI = "https://followchess.com/"
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASEURI).addConverterFactory(GsonConverterFactory.create()).build();
    }

    val api : ApiCalls by lazy {
        retrofit.create(ApiCalls::class.java)
    }
}