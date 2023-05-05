package com.ggg.gggapp.fragments.auth

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ggg.gggapp.databinding.FragmentRegBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegBinding? = null
    private val binding get() = _binding!!
    /*    private lateinit var auth: FirebaseAuth
        private lateinit var dataClass: User
        val firebaseStorage = FirebaseStorage.getInstance().getReference("Images")*/
    var image = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegBinding.inflate(inflater)
//        auth = Firebase.auth
//        dataClass = User()
//        binding.addImage.setOnClickListener {
//            AlertDialog.Builder(activity).setPositiveButton("Сделать снимок") { p0, p1 ->
//                val intent = Intent(Intent.ACTION_PICK)
//                intent.type = "image/*"
//                startActivityForResult(intent, 1)
//            }.setNegativeButton("Использовать ссылку") { _, _ ->
//
//            }.create().show()
//        }
        /* binding.RegButton.setOnClickListener {
             if (!binding.emailText.text.toString().isEmpty() && binding.Check.isChecked
                 && !binding.nameText.text.toString()
                     .isEmpty() && !binding.patronymicText.text.toString().isEmpty()
                 && !binding.phoneNumberText.text.toString()
                     .isEmpty() && !binding.sexText.selectedItem.toString().isEmpty()
                 && !binding.surnameText.text.toString()
                     .isEmpty() && !binding.passwordText.text.toString().isEmpty()
             ) {
                 if (image.isNotEmpty() || binding.avatarText.text.toString().isNotEmpty()) {
                     if (image.isNotEmpty()) {
                         dataClass.avatar = image
                     } else {
                         dataClass.avatar = binding.avatarText.text.toString()
                     }
                     dataClass.email = binding.emailText.text.toString()
                     dataClass.name = binding.nameText.text.toString()
                     dataClass.patronymic = binding.patronymicText.text.toString()
                     dataClass.phoneNumber = binding.phoneNumberText.text.toString()
                     dataClass.position = "User"
                     dataClass.sex = binding.sexText.selectedItem.toString()
                     dataClass.surname = binding.surnameText.text.toString()
                     auth.createUserWithEmailAndPassword(
                         binding.emailText.text.toString(),
                         binding.passwordText.text.toString()
                     ).addOnCompleteListener {
                         if (it.isSuccessful) {
                             dataClass.uid = Firebase.auth.uid
                             Database().putUser(Database().getUsers(), dataClass)
                             requireActivity().startActivity(
                                 Intent(
                                     requireActivity(),
                                     BottomNavigationActivity::class.java
                                 )
                             )
                             requireActivity().finish()
                         } else {
                             Toast.makeText(activity, "Регистрация провалена", Toast.LENGTH_SHORT)
                                 .show()
                         }
                     }
                 }
             } else {
                 Toast.makeText(activity, "Вы оставили какое-то поле пустым", Toast.LENGTH_SHORT)
                     .show()
             }
         }*/
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}