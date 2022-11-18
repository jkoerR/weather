package com.example.droi_mvvm

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.droi_mvvm.retrofit.Retrofit_Contract

import com.example.droi_mvvm.callback.OnItemClick
import com.google.gson.Gson
import com.google.gson.JsonObject

abstract class BaseFragment : Fragment(), View.OnClickListener,
    OnItemClick {

    var gson = Gson()
    override fun onStart() {
        super.onStart()
    }

    abstract fun _init()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _init()
    }

    override fun onClick(v: View) {
    }

}