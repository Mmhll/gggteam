package com.ggg.gggapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ggg.gggapp.R
import com.ggg.gggapp.databinding.ActivityBottomNavigationBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomNavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_bottom_navigation)

        navView.setupWithNavController(navController)
    }

    /*override fun onBackPressed() {

       *//* if (supportFragmentManager.findFragmentById(R.id.layoutFragment) == WorkTimeViewModel()) {
            supportFragmentManager.beginTransaction()
                .remove(WorkTimeViewModel())
                .commit()
        }
        else if (supportFragmentManager.findFragmentById(R.id.layoutFragment) == RolesViewModel()){
            supportFragmentManager.beginTransaction()
                .remove(RolesViewModel())
                .commit()
        }*//*
    }*/
}