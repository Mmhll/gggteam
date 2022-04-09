package com.ggg.gggapp.fragments.chat

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ggg.gggapp.database.Messenger
import com.ggg.gggapp.databinding.FragmentChatBinding
import com.ggg.gggapp.dataclasses.MessageClass
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ChatFragment : Fragment() {

    private lateinit var binding : FragmentChatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(inflater)
        Log.e("UID", Firebase.auth.uid.toString())
        Messenger().sendMessage(MessageClass(messageText = "О, привет", Firebase.auth.uid.toString()))


        return binding.root
    }

}