package com.ggg.gggapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ggg.gggapp.R
import com.ggg.gggapp.model.MessageClass
import com.ggg.gggapp.model.User

class MessengerAdapter(val data: ArrayList<MessageClass>, val context: Context) :
    RecyclerView.Adapter<MessengerAdapter.VH>() {

    private var array = ArrayList<User>()


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

       /* FirebaseDatabase.getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference("Users").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (snap in snapshot.children) {
                        array.add(snap.getValue(User::class.java)!!)
                    }
                    var user: User? = null
                    for (i in array) {
                        if (i.uid == data[holder.adapterPosition].userId){

                            user = i
                        }
                    }
                    if (user != null) {
                        Glide.with(context).load(user.avatar).centerCrop().circleCrop().into(holder.image)
                        holder.message.text = data[holder.adapterPosition].messageText
                        holder.initials.text = user.name + " " + user.surname
                        holder.time.text = data[holder.adapterPosition].time
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })*/

    }

    override fun getItemCount(): Int {
        return data.size
    }
}