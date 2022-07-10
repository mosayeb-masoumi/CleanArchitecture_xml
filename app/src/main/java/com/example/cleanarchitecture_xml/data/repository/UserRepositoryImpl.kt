package com.example.cleanarchitecture_xml.data.repository

import com.example.cleanarchitecture_xml.data.remote.ApiService
import com.example.cleanarchitecture_xml.data.remote.dto.get_employee.EmployeeDto
import com.example.cleanarchitecture_xml.data.remote.dto.get_list.UserItemModelDto
import com.example.cleanarchitecture_xml.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: ApiService): UserRepository {

    override suspend fun getShowsList(): List<UserItemModelDto> {
        return api.getShowsList()
    }

    override suspend fun getEmployeeItem(id: Int): EmployeeDto {
        return api.getEmployeeItem(id)
    }


}