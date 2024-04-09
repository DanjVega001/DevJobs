package com.devjobs.app.core.util

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

class HeadersInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()


        val request = original.newBuilder()
            .header("X-RapidAPI-Key", "310ba895d9msh5cc5d58bb465184p119fa7jsn3dead6485a92")
            .header("X-RapidAPI-Host", "jsearch.p.rapidapi.com")
            .method(original.method(), original.body())
            .build()

        return chain.proceed(request)
    }
}