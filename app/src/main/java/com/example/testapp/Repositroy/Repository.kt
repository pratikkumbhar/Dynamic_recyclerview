package com.example.testapp.Repositroy

import com.example.testapp.Retrofit.DataModelX
import com.example.testapp.Retrofit.RetrofitInstance

class Repository {
    suspend fun getData():DataModelX{
        return RetrofitInstance.api.getData()
    }
}