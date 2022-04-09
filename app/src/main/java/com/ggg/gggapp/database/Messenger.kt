package com.ggg.gggapp.database

import android.app.AlertDialog
import android.os.Message
import android.util.Log
import com.ggg.gggapp.dataclasses.MessageClass
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class Messenger {

    fun sendMessage(message : MessageClass) {
        var key = Database().getFirebaseReference("Messenger").push().key
        Database().getFirebaseReference("Messenger").child(key!!).setValue(message).addOnCompleteListener {
            if (it.isSuccessful){
                Log.e("TAG", "Success")
            }
            else{
                Log.e("TAG", it.exception.toString())
            }
        }
    }
}