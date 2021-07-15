package com.example.testapp

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.Repositroy.MyViewModel
import com.example.testapp.Repositroy.MyViewModelFactory
import com.example.testapp.Repositroy.Repository

class MainActivity : AppCompatActivity() {
private lateinit var viewmodel:MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview);
        var Adaptor : RecyclerAdaptor

        val repository = Repository()
        val myViewModelFactory = MyViewModelFactory(repository)
        viewmodel = ViewModelProvider(this,myViewModelFactory).get(MyViewModel::class.java)
        viewmodel.getData()
        viewmodel.MyResponse.observe(this, Observer { response ->
            if(this.resources.configuration.orientation==Configuration.ORIENTATION_PORTRAIT)
            {recyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
                Adaptor = RecyclerAdaptor(response.trns,this);
                Adaptor.notifyDataSetChanged()
                recyclerview.adapter = Adaptor
            }
            else if (this.resources.configuration.orientation==Configuration.ORIENTATION_LANDSCAPE)
            {
                recyclerview.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
                Adaptor = RecyclerAdaptor(response.trns,this);
                Adaptor.notifyDataSetChanged()
                recyclerview.adapter = Adaptor
            }
        })




    }




}