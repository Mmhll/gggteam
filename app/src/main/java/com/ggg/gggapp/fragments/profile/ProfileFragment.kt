package com.ggg.gggapp.fragments.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ggg.gggapp.activities.BottomNavigationActivity
import com.ggg.gggapp.activities.MainActivity
import com.ggg.gggapp.database.Database
import com.ggg.gggapp.databinding.FragmentProfileBinding
import com.ggg.gggapp.dataclasses.UserClass
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import java.lang.Exception

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        var users = ArrayList<UserClass>()
        Database().getFirebaseReference("Users").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (snap in snapshot.children) {
                        var user = snap.getValue(UserClass::class.java)
                        users.add(user!!)
                    }
                    var user: UserClass? = null

                    for (i in users) {
                        if (i.uid == Firebase.auth.uid) {
                            user = i
                            break
                        }
                    }
                    if (user != null) {
                        try {
                            Glide.with(requireActivity()).load(user.avatar)
                                .into(binding.imageViewProfile)
                            binding.nameProfile.setText(user.name)
                            binding.surnameProfile.setText(user.surname)
                            binding.phoneProfile.setText(user.phoneNumber)
                            binding.emailProfile.setText(user.email)
                            binding.changeButton.setOnClickListener {
                                if (
                                    binding.nameProfile.text.isNotEmpty() &&
                                    binding.surnameProfile.text.isNotEmpty() &&
                                    binding.phoneProfile.text.isNotEmpty() &&
                                    binding.emailProfile.text.isNotEmpty()
                                )
                                    user.name = binding.nameProfile.text.toString()
                                user.surname = binding.surnameProfile.text.toString()
                                user.phoneNumber = binding.phoneProfile.text.toString()
                                user.email = binding.emailProfile.text.toString()
                                Database().changeUser(user)
                            }
                        } catch (e: Exception) {
                        }
                    }



                    binding.logoutButton.setOnClickListener {
                        Firebase.auth.signOut()
                        requireActivity().startActivity(Intent(requireActivity(),
                            MainActivity::class.java))
                        requireActivity().finish()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}