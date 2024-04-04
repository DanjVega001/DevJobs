package com.devjobs.app.core.util

import okhttp3.Interceptor
import okhttp3.Response

class HeadersInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()


        val request = original.newBuilder()
            .header("X-RapidAPI-Key", "455ed2d47emshca7805eb88961bfp172e2fjsn360e41984366")
            .header("X-RapidAPI-Host", "jsearch.p.rapidapi.com")
            .method(original.method(), original.body())
            .build()

        return chain.proceed(request)
    }
}