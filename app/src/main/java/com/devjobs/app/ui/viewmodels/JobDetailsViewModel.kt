package com.devjobs.app.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devjobs.app.core.constants.DataResponse
import com.devjobs.app.data.models.JobDetails
import com.devjobs.app.domain.usecases.SearchJobDetailsUsecase
import kotlinx.coroutines.launch

class JobDetailsViewModel:ViewModel(){

    val jobsDetailsModel = MutableLiveData<JobDetails>()
    val isLoading = MutableLiveData<Boolean>()
    private var searchJobDetailsUsecase = SearchJobDetailsUsecase()
    val error = MutableLiveData<String>()

    fun searchJobDetails(jobID:String){
        isLoading.postValue(true)
        viewModelScope.launch {
            when(val result = searchJobDetailsUsecase(jobID)) {
                is DataResponse.Success -> {
                    isLoading.postValue(false)
                    jobsDetailsModel.postValue(result.data)
                }
                is DataResponse.Error -> {
                    isLoading.postValue(false)
                    error.postValue(result.message)
                }
            }
        }
    }

}