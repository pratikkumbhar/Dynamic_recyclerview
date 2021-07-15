package com.example.testapp.Retrofit

import retrofit2.http.GET

interface ApiCalls {
    @GET("/config.json")
    suspend fun getData(): DataModelX
}