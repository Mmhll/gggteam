package com.ggg.gggapp.fragments.chat

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ggg.gggapp.adapters.MessengerAdapter
import com.ggg.gggapp.database.Messenger
import com.ggg.gggapp.databinding.FragmentChatBinding
import com.ggg.gggapp.dataclasses.MessageClass
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private lateinit var rtDatabase: DatabaseReference
    private lateinit var userArrayList: ArrayList<MessageClass>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(inflater)
        rtDatabase = FirebaseDatabase
            .getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference("Messenger")
        var array = ArrayList<MessageClass>()
        userArrayList = ArrayList<MessageClass>()
        rtDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    array.clear()
                    for (snap in snapshot.children) {
                        val message = snap.getValue(MessageClass::class.java)
                        array.add(message!!)
                    }

                    binding.recyclerChat.adapter = MessengerAdapter(array, requireContext())
                    binding.recyclerChat.scrollToPosition(array.size-1)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        binding.sendButton.setOnClickListener {
            if (binding.messageChat.text.isNotEmpty()) {
                val sdf = SimpleDateFormat("hh:mm")
                val currentDate = sdf.format(Date())
                Messenger().sendMessage(
                    message = MessageClass(
                        messageText = binding.messageChat.text.toString(),
                        time = currentDate,
                        userId = Firebase.auth.uid
                    )
                )
            }
        }
        return binding.root
    }

}