package com.example.cleanarchitecture_xml.common

sealed class Resource2<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource2<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource2<T>(data, message)
    class Loading<T>(data: T? = null) : Resource2<T>(data)
}