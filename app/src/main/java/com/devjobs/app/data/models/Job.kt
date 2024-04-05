package com.devjobs.app.data.models

import com.google.gson.annotations.SerializedName

data class Job (
    @SerializedName("job_id") val id:String,
    @SerializedName("employer_name") val employerName:String,
    @SerializedName("employer_logo") val employerLogo:String?,
    @SerializedName("job_title") val jobTitle:String,
    @SerializedName("job_city") val jobCity:String,
    @SerializedName("job_country") val jobCountry:String,

)