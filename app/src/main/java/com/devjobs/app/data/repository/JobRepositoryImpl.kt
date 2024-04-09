package com.devjobs.app.data.repository

import com.devjobs.app.core.constants.DataResponse
import com.devjobs.app.data.models.Job
import com.devjobs.app.data.models.JobDetails
import com.devjobs.app.data.models.Salary
import com.devjobs.app.data.network.JobService
import com.devjobs.app.domain.repository.JobRepository

class JobRepositoryImpl:JobRepository {

    private val service = JobService()

    override suspend fun searchJobs(query:String): List<Job> {
         return service.searchJobs(query)
    }
    override suspend fun searchJobById(id: String): DataResponse<JobDetails> {
        return service.searchJobById(id)
    }
    override suspend fun estimatedSalary(jobTitle: String, location: String): DataResponse<Salary> {
        return service.estimatedSalary(jobTitle, location)
    }


}