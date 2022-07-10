package com.example.cleanarchitecture_xml.data.remote.dto.get_employee

import com.example.cleanarchitecture_xml.domain.model.employee.Employee

data class EmployeeDto(
    val data : EmployeeDataDto,
    val message: String,
    val status: String
)

fun EmployeeDto.toEmolpyee(): Employee {
    return Employee(
        data = data,
        message = message,
        status = status
    )
}


