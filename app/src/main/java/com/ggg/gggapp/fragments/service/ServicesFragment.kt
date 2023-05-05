package com.ggg.gggapp.fragments.service

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ggg.gggapp.databinding.FragmentServicesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ServicesFragment : Fragment() {

    private var _binding: FragmentServicesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentServicesBinding.inflate(inflater, container, false)

        /*binding.hoursButton.setOnClickListener {
            binding.layoutFragment.visibility = View.VISIBLE
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(com.ggg.gggapp.R.id.layoutFragment, WorkTimeViewModel()).commit()
        }
        binding.roleButton.setOnClickListener {
            binding.layoutFragment.visibility = View.VISIBLE
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(com.ggg.gggapp.R.id.layoutFragment, RolesViewModel()).commit()
        }
        binding.changePassword.setOnClickListener{
            binding.layoutFragment.visibility = View.VISIBLE
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(com.ggg.gggapp.R.id.layoutFragment, ResetPasswordViewModel()).commit()
        }*/
        binding.docsButton.setOnClickListener {
            /*var reference = FirebaseDatabase.getInstance().getReference("docs")
            var key = reference.push().key
            reference.child(key.toString()).setValue(Firebase.auth.uid)
            Toast.makeText(requireContext(), "Заявка подана успешно, ожидайте", Toast.LENGTH_SHORT).show()*/
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}