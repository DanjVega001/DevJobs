package com.devjobs.app.data.network

import com.devjobs.app.core.constants.Constants
import com.devjobs.app.core.constants.DataResponse
import com.devjobs.app.core.util.RetrofitHelper
import com.devjobs.app.data.models.Job
import com.devjobs.app.data.models.JobDetails
import com.devjobs.app.data.models.SearchJobDetailsDataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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
                .searchJobById(id)
            if (!response.isSuccessful) DataResponse.Error(response.message())
            val dataResponse = response.body()
            if (dataResponse?.status == "0K") DataResponse.Success(dataResponse.data)
            else DataResponse.Error(response.message())
        }
    }
}