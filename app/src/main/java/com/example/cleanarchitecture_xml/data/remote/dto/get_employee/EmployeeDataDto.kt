package com.example.cleanarchitecture_xml.data.remote.dto.get_employee

import com.example.cleanarchitecture_xml.domain.model.employee.EmployeeData

data class EmployeeDataDto(
    val employee_age: Int,
    val employee_name: String,
    val employee_salary: Int,
    val id: Int,
    val profile_image: String
)

fun EmployeeDataDto.toEmployeeData() : EmployeeData {
    return EmployeeData(
        employee_age = employee_age,
        employee_name = employee_name,
        employee_salary = employee_salary,
        id = id,
        profile_image = profile_image
    )
}