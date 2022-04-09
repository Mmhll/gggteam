package com.ggg.gggapp.fragments.chat

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ggg.gggapp.adapters.MessengerAdapter
import com.ggg.gggapp.database.Database
import com.ggg.gggapp.database.Messenger
import com.ggg.gggapp.databinding.FragmentChatBinding
import com.ggg.gggapp.dataclasses.MessageClass
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class ChatFragment : Fragment() {

    private lateinit var binding : FragmentChatBinding
    private lateinit var rtDatabase : DatabaseReference
    private lateinit var userArrayList : ArrayList<MessageClass>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(inflater)
        rtDatabase = FirebaseDatabase
            .getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference("Messenger")
        Messenger().sendMessage(MessageClass(messageText = "О, привет", userId = Firebase.auth.uid.toString(), time = "19:46"))
        var array = ArrayList<MessageClass>()
        userArrayList = ArrayList<MessageClass>()

        rtDatabase.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (snap in snapshot.children) {
                            val message = snap.getValue(MessageClass::class.java)
                            array.add(message!!)
                            Log.e("PIZDA", array.toString())
                        }

                    }
                    else{
                        Log.e("ERROR", snapshot.hasChildren().toString())
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
        getUserData()

        return binding.root
    }
    private fun getUserData() {

        rtDatabase = FirebaseDatabase.getInstance().getReference("Users")

        rtDatabase.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){
                        val message = userSnapshot.getValue(MessageClass::class.java)
                        userArrayList.add(message!!)

                    }

                    binding.recyclerChat.adapter = MessengerAdapter(userArrayList, requireContext())

                }

            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("TAG", error.message)
            }


        })

    }
}