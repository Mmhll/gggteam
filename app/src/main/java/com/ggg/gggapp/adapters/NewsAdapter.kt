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

    private var array = ArrayList<NewsClass>()

    class VHH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.titleImage)
        var title: TextView = itemView.findViewById(R.id.titleText)
        var description: TextView = itemView.findViewById(R.id.descriptionText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHH {
        return VHH(LayoutInflater.from(context).inflate(R.layout.news_item, parent, false))
    }

    override fun onBindViewHolder(holder: VHH, position: Int) {

        FirebaseDatabase.getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference("News").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (snap in snapshot.children) {
                            array.add(snap.getValue(NewsClass::class.java)!!)
                        }
                        var news = NewsClass()
                        Glide.with(context).load(news.image).centerCrop().circleCrop().into(holder.image)
                        holder.title.text = news.titleText
                        holder.description.text = news.descriptionText
                    }
                }
                override fun onCancelled(error: DatabaseError) {

                }
            })

    }

    override fun getItemCount(): Int {
        return data.size
    }
}