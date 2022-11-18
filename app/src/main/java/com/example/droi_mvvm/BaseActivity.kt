package com.example.droi_mvvm

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.droi_mvvm.retrofit.Retrofit_Contract
//import com.example.droi_mvvm.retrofit.Retrofit_Presenter
import com.example.droi_mvvm.callback.OnItemClick
import com.google.gson.Gson
import com.google.gson.JsonObject

abstract class BaseActivity : AppCompatActivity(), View.OnClickListener,
    OnItemClick {


    var gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _init()
    }

    abstract fun _init()

    override fun onClick(v: View) {
    }
    override fun onclic(v: View, position: Int) {

    }
}