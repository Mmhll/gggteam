package com.ggg.gggapp.fragments.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ggg.gggapp.R
import com.ggg.gggapp.activities.BottomNavigationActivity
import com.ggg.gggapp.adapters.MessengerAdapter
import com.ggg.gggapp.adapters.NewsAdapter
import com.ggg.gggapp.database.Database
import com.ggg.gggapp.databinding.FragmentNewsBinding
import com.ggg.gggapp.dataclasses.MessageClass
import com.ggg.gggapp.dataclasses.NewsClass
import com.ggg.gggapp.dataclasses.UserClass
import com.ggg.gggapp.fragments.authes.RegFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var rtDatabase: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        try{
            binding = FragmentNewsBinding.inflate(inflater)
            getData()
            auth = Firebase.auth
            rtDatabase = FirebaseDatabase
                .getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference("News")
            var array = ArrayList<NewsClass>()
            binding.addButton.setOnClickListener{
                binding.framCont.visibility = View.VISIBLE
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fram_cont, AddNewsFragment()).commit()
            }
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

    fun getData(){
        rtDatabase = FirebaseDatabase
            .getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference("Users")
        rtDatabase.child(Firebase.auth.uid.toString()).addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var a = snapshot.getValue(UserClass::class.java)
                    if(a!!.position.equals("Admin")){
                        binding.addButton.visibility = View.VISIBLE
                    }
                }
                override fun onCancelled(error: DatabaseError) {

                }
            }
        )
    }
}