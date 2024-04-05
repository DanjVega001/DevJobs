package com.devjobs.app.core.constants



sealed class DataResponse<out T> {
    data class Success<T:Any>(val data: T) : DataResponse<T>()
    data class Error(val message: String) : DataResponse<Nothing>()

}

