package com.devjobs.app.domain.repository

import com.devjobs.app.core.constants.DataResponse
import com.devjobs.app.data.models.Job
import com.devjobs.app.data.models.JobDetails

interface JobRepository {

    suspend fun searchJobs(query:String) : List<Job>

    suspend fun searchJobById(id:String) : DataResponse<JobDetails>
}