package com.ggg.gggapp.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ggg.gggapp.R
import com.ggg.gggapp.databinding.ActivityMainBinding
import com.ggg.gggapp.fragments.auth.AuthFragment
import com.ggg.gggapp.fragments.auth.RegistrationFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var ImageUri: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        if (auth.currentUser != null) {
            intent = Intent(this, BottomNavigationActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_Fragment, AuthFragment())
                .commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.findFragmentById(R.id.container_Fragment) != RegistrationFragment()) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_Fragment, AuthFragment())
                .commit()
        }
    }
}


