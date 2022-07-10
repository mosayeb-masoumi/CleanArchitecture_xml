package com.example.cleanarchitecture_xml.domain.usecase.get_list

import com.example.cleanarchitecture_xml.common.Resource
import com.example.cleanarchitecture_xml.data.remote.dto.UserItemModelDto
import com.example.cleanarchitecture_xml.data.remote.dto.toUserModelItem
import com.example.cleanarchitecture_xml.domain.model.UserItemModel
import com.example.cleanarchitecture_xml.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetListUseCase @Inject constructor(private val repository: UserRepository){


    operator fun invoke(): Flow<Resource<List<UserItemModel>>> = flow {

        try {

            emit(Resource.Loading())
            val users = repository.getShowsList().map { it.toUserModelItem() }
            emit(Resource.Success(users))

        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "an unexpected error occured", null))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage ?: "check your internet connection", null))
        }
    }

}