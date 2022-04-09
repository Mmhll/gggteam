package com.ggg.gggapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ggg.gggapp.R
import com.ggg.gggapp.database.Database
import com.ggg.gggapp.dataclasses.MessageClass

class MessengerAdapter(val data : ArrayList<MessageClass>, val context : Context) : RecyclerView.Adapter<MessengerAdapter.VH>() {
    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image : ImageView = itemView.findViewById(R.id.messageImage)
        var message : TextView = itemView.findViewById(R.id.messageText)
        var initials : TextView = itemView.findViewById(R.id.messageInitials)
        var time : TextView = itemView.findViewById(R.id.messageTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.chat_item, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        var users = Database().getUsers()


        Glide.with(context).load(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}