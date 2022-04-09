package com.ggg.gggapp.adapters

import android.content.Context
import android.util.Log
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
import com.ggg.gggapp.dataclasses.UserClass
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MessengerAdapter(val data: ArrayList<MessageClass>, val context: Context) :
    RecyclerView.Adapter<MessengerAdapter.VH>() {

    private var array = ArrayList<UserClass>()
    var user: UserClass = UserClass()

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.messageImage)
        var message: TextView = itemView.findViewById(R.id.messageText)
        var initials: TextView = itemView.findViewById(R.id.messageInitials)
        var time: TextView = itemView.findViewById(R.id.messageTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.chat_item, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        FirebaseDatabase.getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference("Users").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (snap in snapshot.children) {
                        array.add(snap.getValue(UserClass::class.java)!!)
                    }
                    Log.e("TAG", array.toString())
                    for (i in data) {
                        if (i.userId == array[holder.adapterPosition].uid) {
                            user = array[holder.adapterPosition]
                        }
                    }
                    if (user.uid != "") {
                        Glide.with(context).load(user.avatar).centerCrop().circleCrop().into(holder.image)
                        holder.message.text = data[holder.adapterPosition].messageText
                        holder.initials.text = user.name + user.surname
                        holder.time.text = data[holder.adapterPosition].time
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun getUsers(position: Int) {
    }
}