package com.duongdk.hust.it4785.gmailclonebyusingrecyclerview

import android.graphics.Color
import android.graphics.PorterDuff
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class EmailAdapter(private val emails : ArrayList<EmailModel>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {

    class ViewHolder(private val row : View) : RecyclerView.ViewHolder(row) {
        val sender: TextView = row.findViewById<TextView>(R.id.sender)
        val title: TextView = row.findViewById<TextView>(R.id.mail_title)
        val content: TextView = row.findViewById<TextView>(R.id.mail_content)
        val senderAvatar: TextView = row.findViewById<TextView>(R.id.sender_avatar)
        val time: TextView = row.findViewById<TextView>(R.id.time)
        val star: ImageView = row.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout : View = LayoutInflater.from(parent.context).inflate(R.layout.single_mail_layout, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return emails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.v("TAG", "onBindViewHolder Selected")
        val email =  emails[position]
        holder.sender.text = email.sender
        holder.title.text = email.title
        holder.content.text = email.content
        holder.senderAvatar.text = email.sender.substring(0, 1).uppercase()
        val backgroundColor = generateRandomColor()
        holder.senderAvatar.background.setColorFilter(backgroundColor, PorterDuff.Mode.SRC_IN)
        holder.star.setImageResource(R.drawable.star_favorite_0)
        var isFavorite = false
        holder.star.setOnClickListener {
            if (isFavorite) {
                holder.star.setImageResource(R.drawable.star_favorite_0)
            } else holder.star.setImageResource(R.drawable.star_favorite_1)
            isFavorite = !isFavorite
        }
        holder.time.text = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date(email.timestamp))
    }
    private fun generateRandomColor(): Int {
        val red = (0..255).random()
        val green = (0..255).random()
        val blue = (0..255).random()
        return Color.rgb(red, green, blue)
    }
}