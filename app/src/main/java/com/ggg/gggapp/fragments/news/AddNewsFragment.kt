package com.ggg.gggapp.fragments.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ggg.gggapp.R
import com.ggg.gggapp.databinding.FragmentAddNewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNewsFragment : Fragment() {

    private var _binding: FragmentAddNewsBinding? = null
    private val binding get() = _binding!!
    //private lateinit var rtDatabase: DatabaseReference
    private lateinit var text : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNewsBinding.inflate(inflater)
        binding.AddNews.setOnClickListener {
            if (!binding.text.text.toString().isEmpty() && !binding.title.text.toString()
                    .isEmpty() && !binding.url.text.toString().isEmpty()
            ) {
                text = if(binding.News.isChecked){
                    "News"
                } else if(binding.Event.isChecked){
                    "Event"
                } else{
                    "null"
                }
                /*var key = Database().getFirebaseReference("News").push().key
                rtDatabase = Database().getFirebaseReference("News")
                rtDatabase.child(key.toString()).setValue(
                    NewsClass(
                        binding.text.text.toString(),
                        binding.url.text.toString(),
                        binding.title.text.toString(),
                        text
                    )
                )*/
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fram_cont, NewsFragment()).commit()
            } else {
                Toast.makeText(activity, "Вы не заполнили какое-то поле", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}