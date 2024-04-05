package com.devjobs.app.core.util

import okhttp3.Interceptor
import okhttp3.Response

class HeadersInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()


        val request = original.newBuilder()
            .header("X-RapidAPI-Key", "a0af7b798amsh7c2cfe35c586887p1d6334jsnd0573421cd9f")
            .header("X-RapidAPI-Host", "jsearch.p.rapidapi.com")
            .method(original.method(), original.body())
            .build()

        return chain.proceed(request)
    }
}