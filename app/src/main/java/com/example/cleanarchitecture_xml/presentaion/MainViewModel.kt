package com.example.cleanarchitecture_xml.presentaion

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture_xml.common.Resource
import com.example.cleanarchitecture_xml.domain.model.employee.Employee
import com.example.cleanarchitecture_xml.domain.model.user_list.UserItemModel
import com.example.cleanarchitecture_xml.domain.usecase.employee_usecase.GetEmployeeUseCase
import com.example.cleanarchitecture_xml.domain.usecase.get_list.GetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getListUseCase: GetListUseCase,
    private val getEmployeeUseCase: GetEmployeeUseCase
    ) : ViewModel() {


    val getListLiveData: MutableLiveData<Resource<List<UserItemModel>>> =
        MutableLiveData<Resource<List<UserItemModel>>>()

    val getEmployeeLiveData: MutableLiveData<Resource<Employee>> =
        MutableLiveData<Resource<Employee>>()


    fun getUserList() {
        getListUseCase().onEach { result ->

            Log.i("TAG", "getCoins: ")

            if (result.status == Resource.Status.LOADING) {
                getListLiveData.value = Resource.Loading()
            } else if (result.status == Resource.Status.SUCCESS) {
                getListLiveData.value = Resource.Success(result.data)
            } else if (result.status == Resource.Status.ERROR) {
                getListLiveData.value = Resource.Error(result.message+" error occured!!!")
            }

        }.launchIn(viewModelScope)
    }




    fun getEmployee(id : Int) {
        getEmployeeUseCase(id).onEach { result ->

            Log.i("TAG", "getCoins: ")

            if (result.status == Resource.Status.LOADING) {
                getEmployeeLiveData.value = Resource.Loading()
            } else if (result.status == Resource.Status.SUCCESS) {
                getEmployeeLiveData.value = Resource.Success(result.data)
            } else if (result.status == Resource.Status.ERROR) {
                getEmployeeLiveData.value = Resource.Error( result.message+"  error occured!!!")
            }

        }.launchIn(viewModelScope)
    }







    public override fun onCleared() {
        getListLiveData.value = null
    }

    fun onEmployeeClear(){
        getEmployeeLiveData.value = null
    }
}