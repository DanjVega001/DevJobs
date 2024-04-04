package com.devjobs.app.data.repository

import com.devjobs.app.data.models.Job
import com.devjobs.app.data.network.JobService
import com.devjobs.app.domain.repository.JobRepository

class JobRepositoryImpl:JobRepository {

    private val service = JobService()

    override suspend fun searchJobs(query:String): List<Job> {
         return service.searchJobs(query)
    }


}