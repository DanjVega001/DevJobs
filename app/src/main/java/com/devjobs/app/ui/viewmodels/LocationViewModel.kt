package com.devjobs.app.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devjobs.app.core.constants.Locations

class LocationViewModel : ViewModel() {
    val locationsModel:MutableLiveData<List<String>> = MutableLiveData()

    fun searchLocations(query:String){
        locationsModel.postValue(Locations.getLocations(query))
    }

}