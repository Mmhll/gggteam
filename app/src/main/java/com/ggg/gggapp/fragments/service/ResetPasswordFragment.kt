package com.ggg.gggapp.fragments.service

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ggg.gggapp.databinding.FragmentResetPasswordBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResetPasswordFragment : Fragment() {

    private var _binding: FragmentResetPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResetPasswordBinding.inflate(inflater)
        /*auth = Firebase.auth
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
        }*/

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}