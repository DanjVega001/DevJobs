package com.devjobs.app.data.models

import com.google.gson.annotations.SerializedName

data class Salary(
    @SerializedName("publisher_name") val publisherName:String,
    @SerializedName("publisher_link") val publisherLink:String,
    @SerializedName("min_salary") val minSalary:Double,
    @SerializedName("max_salary") val maxSalary:Double,
    @SerializedName("median_salary") val medianSalary:Double,
    @SerializedName("salary_period") val salaryPeriod:String,
    @SerializedName("salary_currency") val salaryCurrency:String,

)