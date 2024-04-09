package com.devjobs.app.domain.usecases

import com.devjobs.app.core.constants.DataResponse
import com.devjobs.app.data.models.JobDetails
import com.devjobs.app.data.repository.JobRepositoryImpl
import com.devjobs.app.domain.repository.JobRepository

class SearchJobDetailsUsecase {

    private val repository:JobRepository = JobRepositoryImpl()

    suspend operator fun invoke(jobID:String):DataResponse<JobDetails>{
        return repository.searchJobById(jobID)
    }
}