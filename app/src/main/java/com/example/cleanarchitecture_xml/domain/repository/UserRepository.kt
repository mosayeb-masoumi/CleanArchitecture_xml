package com.example.cleanarchitecture_xml.domain.repository

import com.example.cleanarchitecture_xml.data.remote.dto.UserItemModelDto
import com.example.cleanarchitecture_xml.domain.model.UserItemModel
import retrofit2.Response

interface UserRepository {

    suspend fun getShowsList(): List<UserItemModelDto>
}