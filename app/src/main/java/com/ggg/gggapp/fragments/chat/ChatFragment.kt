package com.ggg.gggapp.fragments.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ggg.gggapp.databinding.FragmentChatBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(inflater)
        /*rtDatabase = FirebaseDatabase
            .getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference("Messenger")
        var array = ArrayList<MessageClass>()
        rtDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    array.clear()
                    for (snap in snapshot.children) {
                        val message = snap.getValue(MessageClass::class.java)
                        array.add(message!!)
                    }
                    try {
                        binding!!.recyclerChat.adapter = MessengerAdapter(array, requireContext())
                        binding!!.recyclerChat.scrollToPosition(array.size - 1)
                    } catch (e: Exception) {

                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })*/
        binding.sendButton.setOnClickListener {
            if (binding.messageChat.text.isNotEmpty()) {
                /*Messenger().sendMessage(
                    message = MessageClass(
                        messageText = binding!!.messageChat.text.toString(),
                        time = currentDate,
                        userId = Firebase.auth.uid
                    )
                )*/
                binding.messageChat.text.clear()
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}