package com.example.droi_mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.droi_mvvm.App
import com.example.droi_mvvm.R
import com.example.droi_mvvm.model.GDTO
import com.example.droi_mvvm.util.Logger
import com.example.droi_mvvm.util.Util
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


//class MainViewModel(application: Application) : AndroidViewModel(application),
//    Retrofit_Contract.model.onModelListener {
class MainViewModel(application: Application) : AndroidViewModel(application){

    var gson = Gson()
    var dtos = ArrayList<GDTO.city>()
    var liveData: MutableLiveData<ArrayList<GDTO.city>> = MutableLiveData<ArrayList<GDTO.city>>()
    var weatherData: MutableLiveData<GDTO.weather_base> = MutableLiveData<GDTO.weather_base>()
    val context = getApplication<Application>().applicationContext

    init {

    }

    fun requsetWeather(id: String) {
        Logger.loge("requsetWeather")
        val call_response: Call<JsonObject?>? = App.retrofitService.getw(
            id,
            context.getString(R.string.openweathermap),
//            "6",
            "kr",
            "metric",
        )
        call_response?.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
//                Logger.loge("onResponse  :  " + response.body());
                if (response.body() != null) {
                    Logger.loge("response.body()  :  " + response.body());
//                    onFinished(response.body(), "getw")
                    weatherData.value = gson.fromJson(response.body().toString(), GDTO.weather_base::class.java)
                }
            }
            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
//                App().disProgress()
                Logger.loge("${t.message}")
                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
            }
        })

    }

//    override fun onFinished(json: JsonObject?, from: String?) {
//        when (from) {
//            "getw" -> {
//                Logger.loge("${json}")
////                var weather = gson.fromJson(json?.get("weather").toString(),GDTO.weather::class.java)
//                weatherData.value = gson.fromJson(json.toString(), GDTO.weather_base::class.java)
//            }
//        }
//    }
}