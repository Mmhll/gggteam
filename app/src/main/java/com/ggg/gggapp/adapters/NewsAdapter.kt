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
import com.ggg.gggapp.dataclasses.NewsClass
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class NewsAdapter(val data: ArrayList<NewsClass>, val context: Context) :
    RecyclerView.Adapter<NewsAdapter.VHH>() {

    class VHH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.titleImage)
        var title: TextView = itemView.findViewById(R.id.titleText)
        var description: TextView = itemView.findViewById(R.id.descriptionText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHH {
        return VHH(LayoutInflater.from(context).inflate(R.layout.news_item, parent, false))
    }

    override fun onBindViewHolder(holder: VHH, position: Int) {

        Glide.with(context).load(data[holder.adapterPosition].image).centerCrop()
            .into(holder.image)
        holder.title.text = data[holder.adapterPosition].titleText
        holder.description.text = data[holder.adapterPosition].descriptionText
    }


    override fun getItemCount(): Int {
        return data.size
    }
}