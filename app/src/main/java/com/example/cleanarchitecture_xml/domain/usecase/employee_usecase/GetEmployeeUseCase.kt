package com.example.cleanarchitecture_xml.domain.usecase.employee_usecase

import com.example.cleanarchitecture_xml.common.Resource
import com.example.cleanarchitecture_xml.data.remote.dto.get_employee.toEmolpyee
import com.example.cleanarchitecture_xml.data.remote.dto.get_employee.toEmployeeData
import com.example.cleanarchitecture_xml.data.remote.dto.get_list.toUserModelItem
import com.example.cleanarchitecture_xml.domain.model.employee.Employee
import com.example.cleanarchitecture_xml.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetEmployeeUseCase @Inject constructor(private val repository: UserRepository) {


    operator fun invoke(id: Int): Flow<Resource<Employee>> = flow {

        try {

            emit(Resource.Loading())
            val employee = repository.getEmployeeItem(id).toEmolpyee()
            emit(Resource.Success(employee))

        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "an unexpected error occured", null))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage ?: "check your internet connection", null))
        }
    }

}