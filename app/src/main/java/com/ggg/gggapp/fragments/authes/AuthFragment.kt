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
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthBinding.inflate(inflater)
        binding.RegButton.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container_Fragment, RegFragment()).commit()
        }
        binding.AuthButton.setOnClickListener{
            if(!binding.Login.text.toString().isEmpty() && !binding.Login.text.toString().isEmpty()){
                Auth().auth(binding.Login.text.toString(),binding.Login.text.toString())
                requireActivity().startActivity(Intent(requireActivity(),BottomNavigationActivity::class.java))
                requireActivity().finish()
            }
            else{
                Toast.makeText(activity,"Вы не ввели логин или пароль",Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}