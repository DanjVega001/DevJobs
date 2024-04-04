package com.devjobs.app.domain.repository

import com.devjobs.app.data.models.Job

interface JobRepository {

    suspend fun searchJobs(query:String) : List<Job>
}