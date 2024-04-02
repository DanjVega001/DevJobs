package com.devjobs.app.models

import com.google.gson.annotations.SerializedName

data class RequiredExperience(
    @SerializedName("no_experience_required") val noExperience:Boolean,
    @SerializedName("required_experience_in_months") val experienceInMonths: Int,
    @SerializedName("experience_mentioned") val experienceMentioned:Boolean,
    @SerializedName("experience_preferred") val experiencePreferred:Boolean,

)
