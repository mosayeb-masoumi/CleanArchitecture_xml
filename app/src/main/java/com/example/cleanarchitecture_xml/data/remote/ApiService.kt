package com.example.cleanarchitecture_xml.data.remote

import com.example.cleanarchitecture_xml.data.remote.dto.UserItemModelDto
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("todos/")
    suspend fun getShowsList(): List<UserItemModelDto>


    @GET("/fake/api")
    fun refreshToken(): Call<JsonObject?>?
}