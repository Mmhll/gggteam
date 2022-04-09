package com.ggg.gggapp.fragments.authes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ggg.gggapp.auth.Auth
import com.ggg.gggapp.databinding.FragmentRegBinding
import com.ggg.gggapp.dataclasses.UserClass

class RegFragment : Fragment() {

    private lateinit var binding: FragmentRegBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegBinding.inflate(inflater)
        binding.RegButton.setOnClickListener{
            var dataClass = UserClass()
            if(!binding.avatarText.text.toString().isEmpty() && !binding.emailText.text.toString().isEmpty()
                && !binding.nameText.text.toString().isEmpty() && !binding.patronymicText.text.toString().isEmpty()
                && !binding.phoneNumberText.text.toString().isEmpty() && !binding.sexText.text.toString().isEmpty()
                && !binding.surnameText.text.toString().isEmpty() && !binding.passwordText.text.toString().isEmpty()){
                dataClass.avatar = binding.avatarText.text.toString()
                dataClass.email = binding.emailText.text.toString()
                dataClass.name = binding.nameText.text.toString()
                dataClass.patronymic = binding.patronymicText.text.toString()
                dataClass.phoneNumber = binding.phoneNumberText.text.toString()
                dataClass.position = "User"
                dataClass.sex = binding.sexText.text.toString()
                dataClass.surname = binding.surnameText.text.toString()
                Auth().registration(binding.emailText.text.toString(), binding.passwordText.text.toString(), dataClass)
            }
            else{
                Toast.makeText(activity, "Вы оставили какое-то поле пустым", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}