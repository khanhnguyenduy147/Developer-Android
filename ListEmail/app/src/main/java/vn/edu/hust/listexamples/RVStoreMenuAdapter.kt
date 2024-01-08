package vn.edu.hust.listexamples

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class RVStoreMenuAdapter(
    val items: ArrayList<OneRow>,
    val context: Context
) : RecyclerView.Adapter<RVStoreMenuAdapter.RVMenuViewHolder>() {

    class RVMenuViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
        val recyclerView = itemView.findViewById<RecyclerView>(R.id.rvApps)
        val tvHeading = itemView.findViewById<TextView>(R.id.rowName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVMenuViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_single_horizontal_menu, parent, false)

        return RVMenuViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RVMenuViewHolder, position: Int) {
        holder.recyclerView.adapter = RVStoreItemAdapter(items[position].apps)
        holder.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.recyclerView.setHasFixedSize(true)
        holder.tvHeading.text = items[position].rowName
    }
}