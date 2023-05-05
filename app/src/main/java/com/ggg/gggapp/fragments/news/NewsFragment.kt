package com.ggg.gggapp.fragments.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ggg.gggapp.R
import com.ggg.gggapp.databinding.FragmentNewsBinding
import com.ggg.gggapp.model.NewsClass
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private lateinit var type: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        try{
            _binding = FragmentNewsBinding.inflate(inflater)
            type = "News"
            binding.sorting.setOnClickListener{
                /*if(type.equals("News")){
                    type = "Event"
                }
                else{
                    type = "News"
                }
                rtDatabase = FirebaseDatabase
                        .getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
                    .getReference("News")
                var array = ArrayList<NewsClass>()
                rtDatabase.addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()) {
                            array.clear()
                            for (snap in snapshot.children) {
                                if(snap.getValue(NewsClass::class.java)!!.type.equals(type)){
                                    val news = snap.getValue(NewsClass::class.java)
                                    array.add(news!!)
                                }
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
                })*/
            }
            getData()
           /* auth = Firebase.auth
            rtDatabase = FirebaseDatabase
                .getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference("News")*/
            /*var array = ArrayList<NewsClass>()
            binding.addButton.setOnClickListener{
                binding.framCont.visibility = View.VISIBLE
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fram_cont, AddNewsFragment()).commit()
            }*/
            /*rtDatabase.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        array.clear()
                        for (snap in snapshot.children) {
                            if(snap.getValue(NewsClass::class.java)!!.type.equals(type)){
                            val news = snap.getValue(NewsClass::class.java)
                            array.add(news!!)
                            }
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
            })*/
        }
        catch (ex : Exception){
            Log.e("Tag","$ex")
        }

        return binding.root
    }

    private fun getData(){
        /*rtDatabase = FirebaseDatabase
            .getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference("Users")
        rtDatabase.child(Firebase.auth.uid.toString()).addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var a = snapshot.getValue(User::class.java)
                    if(a!!.position.equals("Admin")){
                        binding.addButton.visibility = View.VISIBLE
                    }
                }
                override fun onCancelled(error: DatabaseError) {

                }
            }
        )*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}