package com.example.cleanarchitecture_xml.presentaion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.runtime.snapshots.Snapshot.Companion.observe
import com.example.cleanarchitecture_xml.R
import com.example.cleanarchitecture_xml.common.Constants
import com.example.cleanarchitecture_xml.common.Resource
import com.example.cleanarchitecture_xml.data.remote.dto.get_employee.toEmployeeData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        /************************************** observe list **************************************/
        btn_get_list.setOnClickListener {
            Constants.BASE_URL = "https://jsonplaceholder.typicode.com/"
            mainViewModel.getUserList()

            val getItemLiveData = mainViewModel.getListLiveData
            getItemLiveData.observe(this) {

                if(it !=null){
                    if (it.status == Resource.Status.SUCCESS) {

                        val result = it.data?.get(0)?.title
                        txt.text = result
                        getItemLiveData.removeObservers(this)
                        mainViewModel.onCleared()  // to prevent looping

                    } else if (it.status == Resource.Status.ERROR) {
                        txt.text = it.message

                    } else if (it.status == Resource.Status.LOADING) {
                        txt.text = "loading..."
                    }
                }

            }
        }










        /************************************** observe object **************************************/


        var employeeId = 0
        btn_get_item.setOnClickListener {

            Constants.BASE_URL = "https://dummy.restapiexample.com/api/v1/"

            employeeId++
            //call
            mainViewModel.getEmployee(employeeId)

            // wait for observing
            val getEmployeeLiveData = mainViewModel.getEmployeeLiveData
            getEmployeeLiveData.observe(this) {

                if(it !=null){
                    if (it.status == Resource.Status.SUCCESS) {

                        val result = it.data

                        result?.data?.employee_name?.let {
                            txt.text = result.data.toEmployeeData().employee_name
                        }

                        getEmployeeLiveData.removeObservers(this)
                        mainViewModel.onEmployeeClear()  // to prevent looping

                    } else if (it.status == Resource.Status.ERROR) {
                        txt.text = it.message

                    } else if (it.status == Resource.Status.LOADING) {
                        txt.text = "loading..."
                    }
                }

            }
        }

    }
}