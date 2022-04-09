package com.ggg.gggapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.ggg.gggapp.Auth
import com.ggg.gggapp.R
import com.ggg.gggapp.database.Database
import com.ggg.gggapp.storage.Storage
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class MainActivity : AppCompatActivity() {
    private lateinit var rtDatabase : DatabaseReference
    private lateinit var storage : FirebaseStorage
    var user = User(name = "Yan", surname = "Gay", email = "yngy@ggg.com", password = "123456qwerty")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rtDatabase = Database().getFirebaseReference("Users")
        storage = FirebaseStorage.getInstance()

        Log.e("TAaaaaaaaaaaaaaaaG", "${Auth().checkAuth()}")

        var array = ArrayList<User>()
        rtDatabase.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    array.clear()
                    for (snap in snapshot.children){
                        array.add(snap.getValue(User::class.java)!!).let {
                            Log.e("TAG", it.toString())
                        }
                    }
                    Database().putUser(rtDatabase, array, user)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        AlertDialog.Builder(this)
            .setPositiveButton("Сделать снимок"
            ) { p0, p1 ->
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                startActivityForResult(intent, 1)
            }
            .setNegativeButton("Использовать ссылку"){ _,_ ->

            }
            .create()
            .show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            1->{
                if (resultCode == RESULT_OK){
                    var uri = data?.data!!
                    Storage().uploadImage(uri, user)
                }
            }
        }
    }
}


data class User(
    var email : String? = "",
    var name : String? = "",
    var password : String? = "",
    var surname : String ? = ""
)

