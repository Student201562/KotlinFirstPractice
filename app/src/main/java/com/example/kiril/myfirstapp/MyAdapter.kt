package com.example.kiril.myfirstapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Kiril on 11.02.2018.
 */
class MyAdapter(private val dataset:  ArrayList<GitHubRepositoryInfo>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val mTextView: TextView = view.findViewById<View>(R.id.my_paragraph_in_recycler_view) as TextView
    }
    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        holder.mTextView.text = dataset[position].name
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder{
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.paragraph_recycler_view, parent, false)
        return ViewHolder(inflatedView)
    }
}