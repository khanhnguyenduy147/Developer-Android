package com.duongdk.hust.it4785.googleplaystoreclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InnerRecyclerViewAdapter(private val innerData: List<AppModel>): RecyclerView.Adapter<InnerRecyclerViewAdapter.ViewHolder>(){

    public final inner class ViewHolder(singleApp: View): RecyclerView.ViewHolder(singleApp) {
        val applicationImage : ImageView = singleApp.findViewById(R.id.appImage)
        val applicationName : TextView = singleApp.findViewById(R.id.appName)
        val applicationRating : TextView = singleApp.findViewById(R.id.rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val singleAppItem = LayoutInflater.from(parent.context).inflate(R.layout.single_application_layout, parent, false)
        return ViewHolder(singleAppItem)
    }

    override fun getItemCount(): Int {
        return innerData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val app = innerData[position]
        holder.applicationImage.setImageResource(app.avatarResId)
        holder.applicationName.text = app.name
        holder.applicationRating.text = app.rating.toString()
    }
}