package com.example.apicall_mvvm.network
import com.example.apicall_mvvm.model.User
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {


    @GET("/repos/octocat/hello-world/issues")
    fun getData(): Call<List<User>>
}