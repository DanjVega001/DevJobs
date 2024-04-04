package com.devjobs.app.domain.usecases

import com.devjobs.app.data.models.Job
import com.devjobs.app.data.repository.JobRepositoryImpl

class SearchJobsUsecase {

    private val repository:JobRepositoryImpl = JobRepositoryImpl()

    suspend operator fun invoke(profession:String, location:String):List<Job> {
        var query = "$profession en $location"
        return repository.searchJobs(query = query)
    }
}