package com.devjobs.app.core.util

import com.devjobs.app.core.constants.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private val client:OkHttpClient = OkHttpClient().newBuilder().addInterceptor(HeadersInterceptor()).build()
    fun getRetrofit():Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(Constants.URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}