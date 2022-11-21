package com.example.droi_mvvm.view//package com.example.droi_mvvm.ui
//
//import android.os.Bundle
//import android.view.View
//import androidx.activity.viewModels
//import androidx.databinding.DataBindingUtil
//import androidx.fragment.app.FragmentManager
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.Observer
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.bumptech.glide.Glide
//import com.example.droi_mvvm.*
//import com.example.droi_mvvm.databinding.ActivityDetailBinding
//import com.example.droi_mvvm.databinding.ActivityMainBinding
//import com.example.droi_mvvm.model.GDTO
//import com.example.droi_mvvm.util.Logger
//import com.example.droi_mvvm.viewmodel.MainViewModel
//
//
//class DetailActivity : BaseActivity() {
//
//    private lateinit var binding: ActivityDetailBinding
//    private val model: MainViewModel by viewModels()
//    lateinit var detaildapter: Detaildapter
//    var data = MutableLiveData<ArrayList<GDTO.weather>>()
//    var key: String = ""
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
//    override fun _init() {
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
//        binding.lifecycleOwner = this
//        model.weatherData.observe(this, Observer {
//            binding.tvDetailTitle.text = it.name
//        })
//        initRecyclerView()
//        key = intent.getStringExtra("id").toString()
//        model.requsetWeather(key)
//    }
//
//    private fun initRecyclerView() {
//        var layout = LinearLayoutManager(this)
//        binding.rvDetail.layoutManager = layout
//        val adapterobsever: Observer<GDTO.weather_base> =
//            Observer {
//                data.value = it.weather
//                detaildapter = Detaildapter(this, data)
//                binding.rvDetail.adapter = detaildapter
//            }
//        model.weatherData.observe(this, adapterobsever)
//    }
//
//    override fun onClick(v: View) {
//        when (v.id) {
////            R.id.fab_minus -> {
////                model.decrease()
////            }
//        }
//    }
//
//    override fun onclic(v: View, position: Int) {
////        Log.e("onclic",  "${v.id}  :  ${position}")
//        when (v.id) {
////            R.id.tv_todo ->{
////                model.modi(position)
//////                adapter.notifyDataSetChanged()
////            }
//        }
//    }
//
//
//}