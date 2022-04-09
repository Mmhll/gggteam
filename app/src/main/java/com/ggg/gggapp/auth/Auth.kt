package com.ggg.gggapp.auth

import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.ggg.gggapp.database.Database
import com.ggg.gggapp.dataclasses.UserClass
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Auth {

    private fun initAuth() : FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    fun registration(
        email : String,
        password : String,
        user : UserClass,
        activity: FragmentActivity
        ){

        initAuth().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
            if (it.isSuccessful){
                Database().putUser(Database().getUsers(), user).let {
                    AlertDialog.Builder(activity)
                        .setMessage(Database().getUsers().toString())
                        .create()
                        .show()
                    auth(email, password)
                }
            }
        }
    }

    fun auth(email: String, password: String){
        initAuth().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener() {
                if (it.isSuccessful){
                }
                else{

                }
            }
    }

    fun checkAuth() : Boolean{
        if (initAuth().currentUser != null){
            return true
        }
        return false
    }
}