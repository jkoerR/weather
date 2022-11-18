package com.everything.inlot.retrofit

import com.google.gson.JsonObject
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*


interface RetrofitService {


    @POST("/init/app_inst.php")
    @FormUrlEncoded
    fun intro(
        @Field("usr_key") usr_key: String?,
        @Field("app_cd") app_cd: String?,
        @Field("auth_token") auth_token: String?,
        @Field("dvc_id") dvc_id: String?,
        @Field("app_ver") app_ver: String?,
        @Field("email") email: String?,
        @Field("usr_nick") usr_nick: String?,
        @Field("sns_id") sns_id: String?,
        @Field("fcm_key") fcm_key: String?,
        @Field("sns_type") sns_type: String?,
        @Field("agree1") agree1: String?,
        @Field("agree2") agree2: String?,
        @Field("push_yn") push_yn: String?
    ): Call<JsonObject?>?

    //    @POST("/data/2.5/weather")
//    @FormUrlEncoded
//    fun getw(
//        @Field("id") usr_key: String?,
//        @Field("appid") app_cd: String?,
//    ): Call<JsonObject?>?
    @GET("/data/2.5/forecast")
    fun getw(
        @Query("q") usr_key: String?,
        @Query("appid") app_cd: String?,
//        @Query("cnt") cnt: String?,
        @Query("lang") lang: String,
        @Query("units") units: String,
    ): Call<JsonObject?>?
}