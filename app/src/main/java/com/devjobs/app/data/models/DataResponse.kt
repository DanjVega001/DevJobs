package com.devjobs.app.data.models

data class SearchJobsDataResponse(
    val data:List<Job>,
    val status:String
)

data class SearchJobDetailsDataResponse(
    val data:JobDetails,
    val status:String
)