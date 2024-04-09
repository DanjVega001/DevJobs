package com.devjobs.app.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devjobs.app.core.constants.DataResponse
import com.devjobs.app.data.models.Salary
import com.devjobs.app.domain.usecases.EstimatedSalaryUsecase
import kotlinx.coroutines.launch

class SalaryViewModel:ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()
    private var estimatedSalaryUsecase = EstimatedSalaryUsecase()
    val salaryModel = MutableLiveData<Salary>()


    fun estimatedSalary(jobTitle:String, location:String){
        isLoading.postValue(true)
        viewModelScope.launch {
            when(val result = estimatedSalaryUsecase(jobTitle, location)) {
                is DataResponse.Success -> {
                    isLoading.postValue(false)
                    salaryModel.postValue(result.data)
                }
                is DataResponse.Error -> {
                    isLoading.postValue(false)
                    error.postValue(result.message)
                }
            }
        }
    }
}