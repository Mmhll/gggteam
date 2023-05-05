package com.ggg.gggapp.fragments.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ggg.gggapp.activities.BottomNavigationActivity
import com.ggg.gggapp.databinding.FragmentAuthBinding
import com.ggg.gggapp.viewmodel.auth.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthFragment : Fragment() {

    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater)

        /*auth = Firebase.auth
        binding.RegButton.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container_Fragment, RegistrationFragment()).commit()
        }
        binding.AuthButton.setOnClickListener{
            if(!binding.Login.text.toString().isEmpty() && !binding.Password.text.toString().isEmpty()){
                auth.signInWithEmailAndPassword(binding.Login.text.toString() ,binding.Password.text.toString()).addOnCompleteListener{
                   if(it.isSuccessful){
                       var prefs = requireActivity().getSharedPreferences("cred", Context.MODE_PRIVATE)
                       prefs.edit().putString("Email", binding.Login.text.toString())
                           .putString("Password", binding.Password.text.toString()).apply()
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
        }*/
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefs = requireActivity().getSharedPreferences("token", Context.MODE_PRIVATE)
        val token = prefs.getString("token", "")!!
        if (token.isNotEmpty()){
            requireActivity().startActivity(Intent(requireActivity(),
                BottomNavigationActivity::class.java))
            requireActivity().finish()
        }
        binding.authButton.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {
                viewModel.authorize(email, password)
                viewModel.data.observe(viewLifecycleOwner) {
                    if ("Bearer" == it.type){
                        prefs.edit().putString("token", it.token).apply()
                        requireActivity().startActivity(Intent(requireActivity(),
                            BottomNavigationActivity::class.java))
                        requireActivity().finish()
                    } else{
                        Toast.makeText(activity,"Неверный логин или пароль",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}