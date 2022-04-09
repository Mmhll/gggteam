package com.ggg.gggapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ggg.gggapp.auth.Auth
import com.ggg.gggapp.R
import com.ggg.gggapp.databinding.ActivityMainBinding
import com.ggg.gggapp.dataclasses.UserClass
import com.ggg.gggapp.fragments.authes.AuthFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Auth().registration("vhjhjgasyaaa@mail.com", password = "1aqaaa", user =
        UserClass(
            name = "Vasyhja",
            surname = "Vasevich",
            patronymic = "Vaseee",
            position = "Admin",
            sex = "Feeemale",
            avatar = "url",
            email = "vasyaaa@mail.com",
            phoneNumber = "+79002223323"
        ))
        if(Auth().checkAuth()){
            intent = Intent(this, BottomNavigationActivity::class.java)
            startActivity(intent)
            finish()
        }
        else{
            supportFragmentManager.beginTransaction().replace(R.id.container_Fragment, AuthFragment())
                .commit()
        }
//
//        rtDatabase = Database().getFirebaseReference("Users")
//        storage = FirebaseStorage.getInstance()
//
//
//        var array = ArrayList<User>()
//        rtDatabase.addValueEventListener(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if(snapshot.exists()){
//                    array.clear()
//                    for (snap in snapshot.children){
//                        array.add(snap.getValue(User::class.java)!!).let {
//                            Log.e("TAG", it.toString())
//                        }
//                    }
//                    Database().putUser(rtDatabase, array, user)
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//
//        })
//        AlertDialog.Builder(this)
//            .setPositiveButton("Сделать снимок"
//            ) { p0, p1 ->
//                val intent = Intent(Intent.ACTION_PICK)
//                intent.type = "image/*"
//                startActivityForResult(intent, 1)
//            }
//            .setNegativeButton("Использовать ссылку"){ _,_ ->
//
//            }
//            .create()
//            .show()
    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        when (requestCode){
//            1->{
//                if (resultCode == RESULT_OK){
//                    var uri = data?.data!!
//                    Storage().uploadImage(uri, user)
//                }
//            }
//        }
//    }
}


