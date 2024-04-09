package com.devjobs.app.data.network

import android.util.Log
import com.devjobs.app.core.constants.Constants
import com.devjobs.app.core.constants.DataResponse
import com.devjobs.app.core.util.RetrofitHelper
import com.devjobs.app.data.models.Job
import com.devjobs.app.data.models.JobDetails
import com.devjobs.app.data.models.Salary
import com.devjobs.app.data.models.SearchJobDetailsDataResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URLEncoder

class JobService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun searchJobs(query:String):List<Job> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(JobApiClient::class.java)
                .searchJobs(query, Constants.NUM_PAGES)
            if (!response.isSuccessful) emptyList<Job>()
            val dataResponse = response.body()
            if (dataResponse?.status == "OK") dataResponse.data
            else emptyList()
        }
    }


    suspend fun searchJobById(id:String): DataResponse<JobDetails> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(JobApiClient::class.java)
                .searchJobById(id.substring(0, id.length-2))
            if (!response.isSuccessful) DataResponse.Error(response.message())
            val dataResponse = response.body()
            DataResponse.Success(dataResponse!!.data[0])
        }
    }


    suspend fun estimatedSalary(jobTitle:String, location:String):DataResponse<Salary>{
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(JobApiClient::class.java)
                .estimatedSalary(jobTitle, location)
            if (!response.isSuccessful) DataResponse.Error(response.message())
            val dataResponse = response.body()
            if (dataResponse!!.data.isNotEmpty()) DataResponse.Success(dataResponse!!.data[dataResponse.data.size-1])
            else DataResponse.Error("No hay salarios")
        }
    }


}