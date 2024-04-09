package com.devjobs.app.domain.usecases

import com.devjobs.app.core.constants.DataResponse
import com.devjobs.app.data.models.Salary
import com.devjobs.app.data.repository.JobRepositoryImpl
import com.devjobs.app.domain.repository.JobRepository

class EstimatedSalaryUsecase {

    private val repository:JobRepository = JobRepositoryImpl()

    suspend operator fun invoke(jobTitle:String, location:String):DataResponse<Salary>{
        return repository.estimatedSalary(jobTitle, location)
    }
}