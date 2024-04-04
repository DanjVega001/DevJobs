package com.devjobs.app.data.models

import com.google.gson.annotations.SerializedName

data class JobDetails(
    @SerializedName("job_id") val id:String,
    @SerializedName("employer_name") val employerName:String,
    @SerializedName("employer_logo") val employerLogo:String,
    @SerializedName("job_employment_type") val jobEmploymentType:String,
    @SerializedName("job_title") val jobTitle:String,
    @SerializedName("job_apply_link") val jobApplyLink:String,
    @SerializedName("job_description") val jobDescription:String,
    @SerializedName("job_is_remote") val isRemote:Boolean,
    @SerializedName("job_posted_at_datetime_utc") val dateTime:String,
    @SerializedName("job_city") val jobCity:String,
    @SerializedName("job_country") val jobCountry:String,
    @SerializedName("job_required_experience") val jobRequiredExperience: RequiredExperience,

    )
