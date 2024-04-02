package com.devjobs.app.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devjobs.app.models.Job

class JobViewModel : ViewModel(){
    val jobsModel = MutableLiveData<List<Job>>()



}