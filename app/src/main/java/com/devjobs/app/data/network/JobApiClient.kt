package com.devjobs.app.data.network

import com.devjobs.app.data.models.DataResponse
import com.devjobs.app.data.models.Job
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JobApiClient {

    @GET("search")
    suspend fun searchJobs(@Query("query") query: String, @Query("num_pages") numPages:Int)
        :Response<DataResponse>
}