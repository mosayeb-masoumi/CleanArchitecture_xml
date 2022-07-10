package com.example.cleanarchitecture_xml.domain.model.employee

import com.example.cleanarchitecture_xml.data.remote.dto.get_employee.EmployeeDataDto

data class Employee(
    val data: EmployeeDataDto,
    val message: String,
    val status: String
)

