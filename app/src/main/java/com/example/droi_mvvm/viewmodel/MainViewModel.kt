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
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


//class MainViewModel(application: Application) : AndroidViewModel(application),
//    Retrofit_Contract.model.onModelListener {
class MainViewModel(application: Application) : AndroidViewModel(application) {

    var gson = Gson()

    //    var liveData: MutableLiveData<ArrayList<GDTO.city>> = MutableLiveData<ArrayList<GDTO.city>>()
    var weatherData: MutableLiveData<GDTO.base> = MutableLiveData<GDTO.base>()
    var weatherProcessing: MutableLiveData<ArrayList<GDTO.Processing>> = MutableLiveData<ArrayList<GDTO.Processing>>()
    val context = getApplication<Application>().applicationContext
    val city = ArrayList<String>()
    var callNum = 0;

    init {
        city.add("Seoul")
        city.add("London")
        city.add("Chicago")
        weatherProcessing.value = ArrayList()
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
//                    Logger.loge("response.body()  :  " + response.body());
//                    onFinished(response.body(), "getw")
                    weatherData.postValue(gson.fromJson(response.body(), GDTO.base::class.java))
                }
            }

            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
//                App().disProgress()
                Logger.loge("${t.message}")
                Util.showToast(context, "인터넷 연결상태가 좋지않습니다.")
            }
        })

    }

    fun calc(it: GDTO.base?) {
        var max = 0.0f
        var min = 100.0f
        var date = ""
        var frequency = ""
        var frequency_count = 0
        val weatherMain = ArrayList<String>()
        val dtos = weatherProcessing.value
        val dto = GDTO.Processing()
        dto.city = city[callNum]
        dto.type = 0
        dtos?.add(dto)
        for (data in it?.list!!) {
//            Logger.loge("dt_txt  :  ${getDateFormatTime(data.dt_txt)}")
            weatherMain.add(data.weather[0].main)
            if (date == "") {
                date = getDateFormatTime(data.dt_txt)
                max = data.main.temp_max
                min = data.main.temp_min
            } else {
                if (date == getDateFormatTime(data.dt_txt)) {
                    if (max < data.main.temp_max) max = data.main.temp_max
                    if (min > data.main.temp_min) min = data.main.temp_min
//                    weatherMain.add(data.weather[0].main)
                } else {
//                    Logger.loge("weatherMain  :   ${weatherMain}")
                    for (main in weatherMain) {
//                        Logger.loge("${Collections.frequency(weatherMain, main)}")
                        if (frequency_count < Collections.frequency(weatherMain, main)) {
                            frequency_count = Collections.frequency(weatherMain, main)
                            frequency = main
                        };
                    }
//                    Logger.loge("frequency  :   ${frequency}")
//                    Logger.loge("min  :   ${min}")
//                    Logger.loge("max  :   ${max}")
                    val d = GDTO.Processing()
                    d.min = min
                    d.max = max
                    d.city = city[callNum]
                    d.weather = frequency
                    d.date = date
                    d.type = 1
                    dtos?.add(d)
                    min = 100.0f
                    max = 0.0f
                    frequency = ""
                    frequency_count = 0
                    weatherMain.clear()
                    date = getDateFormatTime(data.dt_txt)
                }
            }
        }
        weatherProcessing.value = dtos!!
        if (callNum < city.size-1){
            callNum++
            requsetWeather(city[callNum])
        }
//        Logger.loge("weatherProcessing.value  :  ${weatherProcessing.value}")
    }

    fun getDateFormatTime(str: String?): String {
        var time: String = ""
        val ori = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val tran = SimpleDateFormat("yyyy-MM-dd")
        try {
            val oDate = ori.parse(str)
            time = tran.format(oDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return time
    }

}