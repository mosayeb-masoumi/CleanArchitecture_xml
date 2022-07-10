package com.example.cleanarchitecture_xml.data.remote


import com.example.cleanarchitecture_xml.data.remote.dto.get_employee.EmployeeDto
import com.example.cleanarchitecture_xml.data.remote.dto.get_list.UserItemModelDto
import com.google.gson.JsonObject
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("todos/")
    suspend fun getShowsList(): List<UserItemModelDto>

    @GET("employee/{id}")
    suspend fun getEmployeeItem(@Path("id") id: Int) : EmployeeDto


    @GET("/fake/api")
    fun refreshToken(): Call<JsonObject?>?
}