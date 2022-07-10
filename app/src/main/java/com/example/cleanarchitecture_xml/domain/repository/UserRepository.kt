package com.example.cleanarchitecture_xml.domain.repository


import com.example.cleanarchitecture_xml.data.remote.dto.get_employee.EmployeeDto
import com.example.cleanarchitecture_xml.data.remote.dto.get_list.UserItemModelDto
import retrofit2.http.Path

interface UserRepository {

    suspend fun getShowsList(): List<UserItemModelDto>
    suspend fun getEmployeeItem(@Path("id") id: Int) : EmployeeDto
}