package com.syafi.suitmediatest.data.remote.api

import com.syafi.suitmediatest.util.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val api: ApiService= retrofit.create(ApiService::class.java)
}