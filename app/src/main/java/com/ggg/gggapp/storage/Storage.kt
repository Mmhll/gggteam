package com.ggg.gggapp.storage

import android.net.Uri
import androidx.core.net.toUri
import com.ggg.gggapp.dataclasses.UserClass
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import kotlin.random.Random

class Storage {
    private fun initStorage() : FirebaseStorage{
        return FirebaseStorage.getInstance("gs://gggteam-67db1.appspot.com/")
    }
    fun uploadImage(uri : Uri, user: UserClass) : Uri{
        var storage = initStorage().getReference("images")
            .child(user.avatar!! + Random.nextInt(0, Int.MAX_VALUE))
        var ut : UploadTask = storage.putFile(uri)
        var imageUri : Uri = Uri.EMPTY
        var task : Task<Uri> = ut.continueWithTask{
            storage.downloadUrl
        }.addOnCompleteListener {
            imageUri = it.result!!
        }
        return imageUri
    }

}