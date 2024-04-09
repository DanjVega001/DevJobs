package com.devjobs.app.data.models

data class SearchJobsDataResponse(
    val data:List<Job>,
    val status:String
)

data class SearchJobDetailsDataResponse(
    val data:List<JobDetails>,
    val status:String
)

data class EstimatedSalaryDataResponse(
    val data: List<Salary>,
    val status:String
)

