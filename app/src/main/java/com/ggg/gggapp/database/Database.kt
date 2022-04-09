package com.ggg.gggapp.database

import android.util.Log
import com.ggg.gggapp.dataclasses.UserClass
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class Database {

    fun getFirebaseReference(path : String) : DatabaseReference{
        return FirebaseDatabase
            .getInstance("https://gggteam-67db1-default-rtdb.europe-west1.firebasedatabase.app")
            .getReference(path)
    }


    fun putUser(array : ArrayList<UserClass>, user : UserClass){
        var exists = false
        for (i in array){
            if (i == user){
                exists = true
            }
        }
        if (!exists) {
            getFirebaseReference("Users").child(Firebase.auth.uid.toString()).setValue(user).addOnCompleteListener {
                Log.e("TAG", "Success")
            }
        }
    }

    fun getUsers() : ArrayList<UserClass>{
        var array = ArrayList<UserClass>()
        getFirebaseReference("Users").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (snap in snapshot.children) {
                        array.add(snap.getValue(UserClass::class.java)!!)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        return array
    }
}