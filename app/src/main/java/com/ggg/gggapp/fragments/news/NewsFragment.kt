package com.ggg.gggapp.fragments.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ggg.gggapp.adapters.MessengerAdapter
import com.ggg.gggapp.adapters.NewsAdapter
import com.ggg.gggapp.database.Database
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
           /* var key = Database().getFirebaseReference("Messenger").push().key
            rtDatabase.child(key.toString()).setValue(
                NewsClass(
                    "SUPER PIZDEC NOVOST baiden pizdanulsya vsem zaebis",
                    "data:image/jpeg;base64,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",
                        "HUETA"
                    ))*/
            var array = ArrayList<NewsClass>()
            rtDatabase.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        array.clear()
                        for (snap in snapshot.children) {
                            val news = snap.getValue(NewsClass::class.java)
                            array.add(news!!)
                        }
                        try {
                            binding.recyclerNews.adapter = NewsAdapter(array, requireContext())
                        }
                        catch (e : Exception){

                        }
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