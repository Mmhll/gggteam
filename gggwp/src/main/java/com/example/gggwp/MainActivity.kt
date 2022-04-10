package com.example.gggwp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import android.app.Activity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.gggwp.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rtDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        try{
                rtDatabase = FirebaseDatabase
                    .getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
                    .getReference("News")
                var array = ArrayList<NewsClass>()
                rtDatabase.addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                            array.clear()
                            for (snap in snapshot.children) {
                                    val news = snap.getValue(NewsClass::class.java)
                                    array.add(news!!)
                            }
                            try {
                                binding.recyclerNews.adapter = NewsAdapter(array, this@MainActivity)
                            }
                            catch (e : Exception){

                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }
                })
        }
        catch(ex : Exception){
            Toast.makeText(this@MainActivity,"$ex",Toast.LENGTH_SHORT).show()
        }
    }
}