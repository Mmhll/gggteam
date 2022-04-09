package com.ggg.gggapp.auth

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ggg.gggapp.database.Database
import com.ggg.gggapp.dataclasses.UserClass
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.firebase.auth.FirebaseAuth

class Auth {
    private fun initAuth() : FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    fun registration(
        email : String,
        password : String,
        user : UserClass
        ){
        initAuth().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
            if (it.isSuccessful){
                Database().putUser(Database().getUsers(), user).let {
                    Log.e("YEP", "YOP")
                }
            }
            else{
                Log.e("FAIL", it.exception.toString())
            }
        }
    }

    fun auth(email: String, password: String, activity : AppCompatActivity){
        initAuth().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) {
                if (it.isSuccessful){
                    //DO SOME SHIT
                    Log.v("TA1G1", "SUCCESS ")
                }
                else{
                    Log.e("TA1G", "FAIL ${it.exception}")
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