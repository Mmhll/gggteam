package com.ggg.gggapp.storage

import android.net.Uri
import com.ggg.gggapp.activities.User
import com.google.firebase.storage.FirebaseStorage
import kotlin.random.Random

class Storage {
    private fun initStorage() : FirebaseStorage{
        return FirebaseStorage.getInstance("gs://gggteam-67db1.appspot.com/")
    }
    fun uploadImage(uri : Uri, user: User){
        var storage = initStorage().getReference("images")
        storage.child(user.name!! + Random.nextInt(0, Int.MAX_VALUE))
            .putFile(uri)
    }

}