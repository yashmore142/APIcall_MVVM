package com.example.apicall_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apicall_mvvm.adapter.UserAdapter
import com.example.apicall_mvvm.model.User
import com.example.apicall_mvvm.viewModel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerView)
        loadData()
    }
    fun loadData(){

        userViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.getApiData()
        userViewModel.userDataList.observe(this, Observer {
            initAdapter(it)
        })
    }

    private fun initAdapter(data:List<User>){


     recyclerView.layoutManager=LinearLayoutManager(this)
        val adapter=UserAdapter(data)
        recyclerView.adapter=adapter
      //  adapter.notifyDataSetChanged()
        /*recyclerView.layoutManager=LinearLayoutManager(this)
        val linearLayoutManager:LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = linearLayoutManager

        val adapter=UserAdapter(data)
        recyclerView.adapter=adapter*/
    }
}