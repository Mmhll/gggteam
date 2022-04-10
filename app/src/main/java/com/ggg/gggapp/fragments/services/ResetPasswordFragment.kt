package com.ggg.gggapp.fragments.services

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ggg.gggapp.R
import com.ggg.gggapp.databinding.FragmentResetPasswordBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ResetPasswordFragment: Fragment() {

    private lateinit var binding: FragmentResetPasswordBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResetPasswordBinding.inflate(inflater)
        auth = Firebase.auth
        binding.resetPassword.setOnClickListener{
            auth.currentUser?.updatePassword(binding.newPassword.text.toString())?.addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(activity,"Пароль успешно обновлен", Toast.LENGTH_SHORT).show()
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(com.ggg.gggapp.R.id.fragmentContainerServices, WorkTimeFragment()).commit()
                }
                else{
                    Toast.makeText(activity,"Произошла чудовищная ошибка ${it.toString()}", Toast.LENGTH_SHORT).show()

                }
            }
        }

        return binding.root
    }
}