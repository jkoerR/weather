package com.example.droi_mvvm.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.droi_mvvm.BaseFragment
import com.example.droi_mvvm.R
import com.example.droi_mvvm.databinding.FragmentFirstBinding
import com.example.droi_mvvm.model.GDTO
import com.example.droi_mvvm.viewmodel.MainViewModel


class FirstFragment : BaseFragment() {
    lateinit var binding: FragmentFirstBinding
    lateinit var firstAdapter: FirstAdapter

    //    var data = MutableLiveData<ArrayList<DTOS.recy>>()
    var data = MutableLiveData<ArrayList<GDTO.city>>()

    //    private val model: MainViewModel by viewModels()
    private lateinit var model: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
//        return super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun _init() {
        model = ViewModelProvider(activity as FragmentActivity)[MainViewModel::class.java]
        initRecyclerView()
//        model.call_assets()
        model.requsetWeather("Seoul")
    }

    private fun initRecyclerView() {

        binding.rvFirst.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        firstAdapter = FirstAdapter(this, requireActivity())
        binding.rvFirst.adapter = firstAdapter
        val adapterobsever: Observer<ArrayList<GDTO.city>> =
            Observer {
//                data.value = it
                firstAdapter.diff(it, "")
            }
        model.liveData.observe(this, adapterobsever)
    }

    override fun onclic(v: View, position: Int) {
//        Log.e("onclic", "${v.id}  :  ${position}")
        when (v.id) {
//            R.id.tv_todo -> {
////                model.moveDetail(position)
//            }
        }
    }

    override fun onClick(v: View) {
        super.onClick(v)
        var cPosition: Int?
        var cIntent: Intent?
        when (v.id) {
//            R.id.btn_modi -> {
//
//            }
            else -> {

            }
        }
    }
}