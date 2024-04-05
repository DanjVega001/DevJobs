package com.devjobs.app.data.network

import android.util.Log
import com.devjobs.app.core.constants.Constants
import com.devjobs.app.core.util.RetrofitHelper
import com.devjobs.app.data.models.DataResponse
import com.devjobs.app.data.models.Job
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class JobService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun searchJobs(query:String):List<Job> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(JobApiClient::class.java)
                .searchJobs(query, Constants.NUM_PAGES)
            val dataResponse = response.body()
            if (dataResponse?.status == "OK") dataResponse.data
            else emptyList()
        }
    }
}