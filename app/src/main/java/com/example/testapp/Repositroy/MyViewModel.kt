package com.example.testapp.Repositroy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.Retrofit.DataModelX
import kotlinx.coroutines.launch


class MyViewModel(private val repository: Repository) : ViewModel(){
    val MyResponse : MutableLiveData<DataModelX> = MutableLiveData();
    fun getData()
    {
        viewModelScope.launch {
            val response : DataModelX = repository.getData()
            MyResponse.value = response
        }
    }
}