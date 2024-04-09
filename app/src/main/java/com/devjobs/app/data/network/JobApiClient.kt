package com.devjobs.app.data.network

import com.devjobs.app.data.models.EstimatedSalaryDataResponse
import com.devjobs.app.data.models.SearchJobDetailsDataResponse
import com.devjobs.app.data.models.SearchJobsDataResponse
import retrofit2.Response
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface JobApiClient {

    @GET("search")
    suspend fun searchJobs(@Query("query") query: String, @Query("num_pages") numPages:Int)
        :Response<SearchJobsDataResponse>

    @GET("job-details")
    suspend fun searchJobById(@Query("job_id", encoded = false) jobId:String):Response<SearchJobDetailsDataResponse>

    @GET("estimated-salary")
    suspend fun estimatedSalary(@Query("job_title") jobTitle: String, @Query("location") location:String)
            :Response<EstimatedSalaryDataResponse>

}