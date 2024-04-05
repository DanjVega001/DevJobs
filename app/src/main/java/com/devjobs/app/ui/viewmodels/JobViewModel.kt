package com.devjobs.app.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devjobs.app.data.models.Job
import com.devjobs.app.domain.usecases.SearchJobsUsecase
import kotlinx.coroutines.launch

class JobViewModel : ViewModel(){
    val jobsModel = MutableLiveData<List<Job>>()
    var searchJobsUsecase = SearchJobsUsecase()
    fun searchJobs(profession:String, location:String){
        viewModelScope.launch {
            val result = searchJobsUsecase(profession, location)
            jobsModel.postValue(result)
        }
    }



}