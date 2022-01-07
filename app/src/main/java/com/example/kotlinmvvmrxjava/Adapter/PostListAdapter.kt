package com.example.kotlinmvvmrxjava.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvmrxjava.Model.PostModel
import com.example.kotlinmvvmrxjava.R
import java.lang.StringBuilder

class PostListAdapter(var context: Context, var postModelList: MutableList<PostModel>) : RecyclerView.Adapter<PostListAdapter.MyViewHolder> {

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var txtUserId: TextView
        var txtBody: TextView
        var txtTitle: TextView

        init {
            txtUserId = itemView.findViewById(R.id.txtUserId)
            txtBody = itemView.findViewById(R.id.txtBody)
            txtTitle = itemView.findViewById(R.id.txtTitle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.layout_post_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtTitle.text = postModelList[position].title.toString()
        holder.txtBody.text = StringBuilder(postModelList[position].body!!.substring(0, 20))
            .append("...").toString()
        holder.txtUserId.text = postModelList[position].userId.toString()
    }

    override fun getItemCount(): Int {
        return postModelList.size
    }

}