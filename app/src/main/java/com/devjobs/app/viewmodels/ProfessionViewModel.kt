package com.devjobs.app.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devjobs.app.constants.Professions

class ProfessionViewModel : ViewModel() {

    val professionModel:MutableLiveData<List<String>> = MutableLiveData()

    fun searchProfession(query:String){
        professionModel.postValue(Professions.getProfessions(query))
    }
}