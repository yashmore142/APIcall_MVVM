package com.example.apicall_mvvm.viewModel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apicall_mvvm.model.User
import com.example.apicall_mvvm.network.RetrofitInstance
import com.example.apicall_mvvm.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel:ViewModel() {
        var userDataList= MutableLiveData<List<User>>()

    fun getApiData(){
        val retrofitService=RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)

        retrofitService.getData().enqueue(object:Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                userDataList.value=response.body()
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }

        })
    }
}