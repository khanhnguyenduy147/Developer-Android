package vn.edu.hust.listexamples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVEmailItemAdapter(val items: ArrayList<ItemModel>, val listener: ItemClickListener?): RecyclerView.Adapter<RVEmailItemAdapter.RVItemViewHolder>() {
    class RVItemViewHolder(val itemView: View, val listener: ItemClickListener?): RecyclerView.ViewHolder(itemView) {
        val imageThumb: ImageView = itemView.findViewById<ImageView>(R.id.image_thumb)
        val textCaption: TextView = itemView.findViewById<TextView>(R.id.text_caption)
        val checkSelected: CheckBox = itemView.findViewById<CheckBox>(R.id.check_selected)

        init {
            itemView.setOnClickListener {
                listener?.ItemClick(adapterPosition)
            }
        }
    }

    interface ItemClickListener {
        fun ItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_email_single_item, parent, false)

        return RVItemViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RVItemViewHolder, position: Int) {
        val item = items[position]
        holder.imageThumb.setImageResource(items[position].imageThumb)
        holder.textCaption.text = items[position].caption
//        holder.checkSelected.isChecked = items[position].selected
        holder.checkSelected.setOnCheckedChangeListener {_, isChecked ->
            item.selected = isChecked
        }
        holder.checkSelected.isChecked = item.selected
    }
}