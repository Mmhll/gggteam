package com.ggg.gggapp.database

import android.util.Log
import com.ggg.gggapp.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Database {

    fun getFirebaseReference(path : String) : DatabaseReference{
        return FirebaseDatabase
            .getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference(path)
    }


    fun putUser(rtDatabase : DatabaseReference, array : ArrayList<User>, user : User){
        var exists = false
        for (i in array){
            Log.e("TAG1", i.toString())
            Log.e("TAG2", user.toString())
            if (i == user){
                exists = true
            }
        }
        if (!exists) {
            rtDatabase.child("${user.name}_${user.surname}").setValue(user).addOnCompleteListener {
                Log.e("TAG", "Success")
            }
        }
    }
}