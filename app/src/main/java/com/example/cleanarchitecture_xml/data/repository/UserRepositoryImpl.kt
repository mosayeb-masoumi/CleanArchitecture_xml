package com.example.cleanarchitecture_xml.data.repository

import com.example.cleanarchitecture_xml.data.remote.ApiService
import com.example.cleanarchitecture_xml.data.remote.dto.UserItemModelDto
import com.example.cleanarchitecture_xml.domain.repository.UserRepository
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: ApiService): UserRepository {

    override suspend fun getShowsList(): List<UserItemModelDto> {
        return api.getShowsList()
    }
}