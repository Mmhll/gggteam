package com.ggg.gggapp.storage

import android.net.Uri
import com.ggg.gggapp.dataclasses.UserClass
import com.google.firebase.storage.FirebaseStorage
import kotlin.random.Random

class Storage {
    private fun initStorage() : FirebaseStorage{
        return FirebaseStorage.getInstance("gs://gggteam-67db1.appspot.com/")
    }
    fun uploadImage(uri : Uri, user: UserClass){
        var storage = initStorage().getReference("images")
        storage.child(user.avatar!! + Random.nextInt(0, Int.MAX_VALUE))
            .putFile(uri)
    }

}