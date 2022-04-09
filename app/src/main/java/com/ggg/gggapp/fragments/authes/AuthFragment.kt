package com.ggg.gggapp.fragments.authes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ggg.gggapp.R
import com.ggg.gggapp.activities.BottomNavigationActivity
import com.ggg.gggapp.auth.Auth
import com.ggg.gggapp.databinding.FragmentAuthBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthBinding.inflate(inflater)
        auth = Firebase.auth
        binding.RegButton.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container_Fragment, RegFragment()).commit()
        }
        binding.AuthButton.setOnClickListener{
            if(!binding.Login.text.toString().isEmpty() && !binding.Password.text.toString().isEmpty()){
                auth.signInWithEmailAndPassword(binding.Login.text.toString() ,binding.Password.text.toString()).addOnCompleteListener{
                   if(it.isSuccessful){
                       requireActivity().startActivity(Intent(requireActivity(),BottomNavigationActivity::class.java))
                       requireActivity().finish()
                   }else{
                       Toast.makeText(activity,"Неверный логин или пароль",Toast.LENGTH_SHORT).show()
                   }
                }
            }
            else{
                Toast.makeText(activity,"Вы не ввели логин или пароль",Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}