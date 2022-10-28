package com.example.apicall_mvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apicall_mvvm.R
import com.example.apicall_mvvm.model.User

class UserAdapter(private var mList:List<User>):RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val txtId:TextView=itemView.findViewById(R.id.txtId)
        val txtName:TextView=itemView.findViewById(R.id.txtName)
        val txtEmail:TextView=itemView.findViewById(R.id.txtEmail)
   /*     val txtGender:TextView=itemView.findViewById(R.id.txtGender)
        val txtStatus:TextView=itemView.findViewById(R.id.txtStatus)
*/

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_user_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.txtId.text= mList[position].title
        holder.txtName.text=mList[position].created_at
        holder.txtEmail.text=mList[position].body


    }

    override fun getItemCount(): Int {
    return mList.size
    }
}