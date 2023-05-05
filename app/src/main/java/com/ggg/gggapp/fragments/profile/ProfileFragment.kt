package com.ggg.gggapp.fragments.profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ggg.gggapp.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
/*        var users = ArrayList<User>()*/
        /*Database().getFirebaseReference("Users").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (snap in snapshot.children) {
                        var user = snap.getValue(User::class.java)
                        users.add(user!!)
                    }
                    var user: User? = null

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
                            binding.emailProfile.text = user.email
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

        })*/
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.changeButton.setOnClickListener {
            val sharedPrefs = requireActivity().getSharedPreferences("token", Context.MODE_PRIVATE)
            var token = sharedPrefs.getString("token", "")
            //view
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}