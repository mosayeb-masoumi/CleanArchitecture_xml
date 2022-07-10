package com.example.cleanarchitecture_xml.presentaion

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture_xml.common.Resource
import com.example.cleanarchitecture_xml.domain.model.UserItemModel
import com.example.cleanarchitecture_xml.domain.usecase.get_list.GetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getListUseCase: GetListUseCase) : ViewModel() {


    val getListLiveData: MutableLiveData<Resource<List<UserItemModel>>> =
        MutableLiveData<Resource<List<UserItemModel>>>()


    fun getUserList() {
        getListUseCase().onEach { result ->

            Log.i("TAG", "getCoins: ")

            if (result.status == Resource.Status.LOADING) {
                getListLiveData.value = Resource.Loading()
            } else if (result.status == Resource.Status.SUCCESS) {
                getListLiveData.value = Resource.Success(result.data)
            } else if (result.status == Resource.Status.ERROR) {
                getListLiveData.value = Resource.Error("error occured!!!")
            }

        }.launchIn(viewModelScope)
    }










    public override fun onCleared() {
        getListLiveData.value = null
    }
}