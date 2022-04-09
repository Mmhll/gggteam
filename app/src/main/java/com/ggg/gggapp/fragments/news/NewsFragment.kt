package com.ggg.gggapp.fragments.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ggg.gggapp.adapters.MessengerAdapter
import com.ggg.gggapp.adapters.NewsAdapter
import com.ggg.gggapp.databinding.FragmentNewsBinding
import com.ggg.gggapp.dataclasses.MessageClass
import com.ggg.gggapp.dataclasses.NewsClass
import com.google.firebase.database.*

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var rtDatabase: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        try{
            binding = FragmentNewsBinding.inflate(inflater)
            rtDatabase = FirebaseDatabase
                .getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference("News")
            var array = ArrayList<NewsClass>()
            rtDatabase.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        array.clear()
                        for (snap in snapshot.children) {
                            val message = snap.getValue(NewsClass::class.java)
                            array.add(message!!)
                        }

                        binding.recyclerChat.adapter = NewsAdapter(array, requireContext())
                        binding.recyclerChat.scrollToPosition(array.size-1)
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
        }
        catch (ex : Exception){
            Log.e("Tag","$ex")
        }

        return binding.root
    }
}