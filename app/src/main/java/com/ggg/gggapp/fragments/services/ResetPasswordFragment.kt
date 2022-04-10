package com.ggg.gggapp.fragments.services

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ggg.gggapp.R
import com.ggg.gggapp.databinding.FragmentResetPasswordBinding
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ResetPasswordFragment : Fragment() {

    private lateinit var binding: FragmentResetPasswordBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResetPasswordBinding.inflate(inflater)
        auth = Firebase.auth
        binding.resetPassword.setOnClickListener {

            val prefs = requireActivity().getSharedPreferences("cred", Context.MODE_PRIVATE)
            auth.currentUser!!.reauthenticate(
                EmailAuthProvider.getCredential(
                    prefs.getString("Email", "")!!,
                    prefs.getString("Password", "")!!
                )
            ).addOnCompleteListener { it ->
                if (it.isSuccessful) {
                    auth.currentUser!!.updatePassword(binding.newPassword.text.toString())
                        .addOnCompleteListener { it1 ->
                            if (it1.isSuccessful) {
                                prefs.edit().putString("Password", binding.newPassword.text.toString()).apply()
                                Toast.makeText(requireContext(), "YEP", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(
                                    requireContext(),
                                    "${it1.exception}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
        }

        return binding.root
    }
}