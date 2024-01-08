package vn.edu.hust.activityexamples

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class DanhBaItemAdapter(val items: ArrayList<Person>): BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var itemView: View
        var itemViewHolder: ItemViewHolder

        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.activity_danh_ba_item_adapter, parent, false)

            itemViewHolder = ItemViewHolder(itemView)
            itemView.tag = itemViewHolder
        } else {
            itemView = convertView
            itemViewHolder = itemView.tag as ItemViewHolder
        }

        itemViewHolder.name.text = items[position].name
        itemViewHolder.avatar.setImageResource(items[position].avatar)


        return itemView
    }

    class ItemViewHolder(itemView: View) {
        val avatar: ImageView
        val name: TextView
        init {
            name = itemView.findViewById(R.id.name)
            avatar = itemView.findViewById(R.id.avatar)

            Log.v("TAG", "findViewById")
        }
    }
}