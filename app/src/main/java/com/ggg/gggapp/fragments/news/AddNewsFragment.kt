package com.ggg.gggapp.fragments.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ggg.gggapp.R
import com.ggg.gggapp.database.Database
import com.ggg.gggapp.databinding.FragmentAddNewsBinding
import com.ggg.gggapp.databinding.FragmentNewsBinding
import com.ggg.gggapp.dataclasses.NewsClass
import com.google.firebase.database.DatabaseReference

class AddNewsFragment : Fragment() {

    private lateinit var binding: FragmentAddNewsBinding
    private lateinit var rtDatabase: DatabaseReference
    private lateinit var text : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNewsBinding.inflate(inflater)
        binding.AddNews.setOnClickListener {
            if (!binding.text.text.toString().isEmpty() && !binding.title.text.toString()
                    .isEmpty() && !binding.url.text.toString().isEmpty()
            ) {
                if(binding.News.isChecked){
                    text = "News"
                }
                else if(binding.Event.isChecked){
                    text = "Event"
                }
                else{
                    text = "null"
                }
                var key = Database().getFirebaseReference("News").push().key
                rtDatabase = Database().getFirebaseReference("News")
                rtDatabase.child(key.toString()).setValue(
                    NewsClass(
                        binding.text.text.toString(),
                        binding.url.text.toString(),
                        binding.title.text.toString(),
                        text
                    )
                )
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fram_cont, NewsFragment()).commit()
            } else {
                Toast.makeText(activity, "Вы не заполнили какое-то поле", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
}