package com.example.droi_mvvm.view

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
import com.bumptech.glide.Glide
import com.example.droi_mvvm.BaseFragment
import com.example.droi_mvvm.R
import com.example.droi_mvvm.databinding.FragmentFirstBinding
import com.example.droi_mvvm.model.GDTO
import com.example.droi_mvvm.util.Logger
import com.example.droi_mvvm.viewmodel.MainViewModel
import com.facebook.shimmer.ShimmerFrameLayout


class FirstFragment : BaseFragment() {
    lateinit var binding: FragmentFirstBinding
    lateinit var firstAdapter: FirstAdapter

    //    var data = MutableLiveData<ArrayList<DTOS.recy>>()
//    var data = MutableLiveData<ArrayList<GDTO.city>>()

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
        setObseve()
//        model.call_assets()
        startShimmer(binding.sfl)
        model.requsetWeather(model.city[model.callNum])
    }

    fun setObseve() {
        model.weatherData.observe(this) {
            model.calc(it)
        }
    }

    fun startShimmer(view: ShimmerFrameLayout) {
        view.showShimmer(true)
        view.startShimmer()
    }

    fun stopShimmer(view: ShimmerFrameLayout) {
        view.stopShimmer()
        view.hideShimmer()
    }
    private fun initRecyclerView() {

        binding.rvFirst.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        firstAdapter = FirstAdapter(this, requireActivity())
        binding.rvFirst.adapter = firstAdapter
        val adapterobsever: Observer<ArrayList<GDTO.Processing>> =
            Observer {
//                data.value = it
//                Logger.loge("it   :   ${it.size}")
                firstAdapter.diff(it, "")
                if (model.callNum == model.city.size-1){
                    stopShimmer(binding.sfl)
                }
            }
        model.weatherProcessing.observe(this, adapterobsever)
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