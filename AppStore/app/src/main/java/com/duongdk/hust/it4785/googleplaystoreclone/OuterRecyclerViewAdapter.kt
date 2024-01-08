package com.duongdk.hust.it4785.googleplaystoreclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OuterRecyclerViewAdapter(private val outerData: List<List<AppModel>>) : RecyclerView.Adapter<OuterRecyclerViewAdapter.ViewHolder>() {
    public val innerAdapters: MutableList<InnerRecyclerViewAdapter> = mutableListOf()

    public final inner class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        val tag: TextView = row.findViewById(R.id.tag)
        val listApp : RecyclerView = row.findViewById(R.id.listApp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.single_row_layout, parent, false)
        return ViewHolder(row)
    }

    override fun getItemCount(): Int {
        return outerData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val row = outerData[position]
        val innerAdapter = InnerRecyclerViewAdapter(row)
        holder.listApp.layoutManager = LinearLayoutManager(holder.listApp.context, LinearLayoutManager.HORIZONTAL, false)
        holder.listApp.adapter = innerAdapter

        innerAdapters.add(innerAdapter)

        holder.tag.text = row[0].tag
    }
}