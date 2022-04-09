package com.ggg.gggapp.fragments.authes

import android.app.Activity.RESULT_OK
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ggg.gggapp.activities.BottomNavigationActivity
import com.ggg.gggapp.database.Database
import com.ggg.gggapp.databinding.FragmentRegBinding
import com.ggg.gggapp.dataclasses.UserClass
import com.ggg.gggapp.storage.Storage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegFragment : Fragment() {

    private lateinit var binding: FragmentRegBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var dataClass: UserClass

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegBinding.inflate(inflater)
        auth = Firebase.auth
        dataClass = UserClass()
        binding.addImage.setOnClickListener {
            AlertDialog.Builder(activity).setPositiveButton("Сделать снимок"){ p0, p1 ->
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                startActivityForResult(intent, 1)
            }.setNegativeButton("Использовать ссылку"){ _,_ ->

           }.create().show()
        }
        binding.RegButton.setOnClickListener{
            if( !binding.emailText.text.toString().isEmpty() && binding.Check.isChecked
                && !binding.nameText.text.toString().isEmpty() && !binding.patronymicText.text.toString().isEmpty()
                && !binding.phoneNumberText.text.toString().isEmpty() && !binding.sexText.selectedItem.toString().isEmpty()
                && !binding.surnameText.text.toString().isEmpty() && !binding.passwordText.text.toString().isEmpty() ){
                dataClass.avatar = binding.avatarText.text.toString()
                dataClass.email = binding.emailText.text.toString()
                dataClass.name = binding.nameText.text.toString()
                dataClass.patronymic = binding.patronymicText.text.toString()
                dataClass.phoneNumber = binding.phoneNumberText.text.toString()
                dataClass.position = "User"
                dataClass.sex = binding.sexText.selectedItem.toString()
                dataClass.surname = binding.surnameText.text.toString()
                auth.createUserWithEmailAndPassword(binding.emailText.text.toString(), binding.passwordText.text.toString()).addOnCompleteListener{
                    if(it.isSuccessful){
                        dataClass.uid = Firebase.auth.uid
                        Database().putUser(Database().getUsers(), dataClass)
                        requireActivity().startActivity(Intent(requireActivity(),BottomNavigationActivity::class.java))
                        requireActivity().finish()
                    }
                    else{
                        Toast.makeText(activity, "Регистрация провалена", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else{
                Toast.makeText(activity, "Вы оставили какое-то поле пустым", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            1->{
                if (resultCode == RESULT_OK){
                    var uri = data?.data!!
                    Storage().uploadImage(uri, dataClass)
                }
            }
        }
    }
}