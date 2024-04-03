package com.devjobs.app.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devjobs.app.constants.Locations

class LocationViewModel : ViewModel() {
    val locationsModel:MutableLiveData<List<String>> = MutableLiveData()

    fun searchLocations(query:String){
        locationsModel.postValue(Locations.getLocations(query))
    }

}