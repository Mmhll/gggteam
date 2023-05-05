package com.ggg.gggapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ggg.gggapp.R
import com.ggg.gggapp.fragments.auth.AuthFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.containerView, AuthFragment()).commit()
    }
                /*auth.signInWithEmailAndPassword(binding.email.text.toString() ,binding.password.text.toString()).addOnCompleteListener{
                    if(it.isSuccessful){
                        var prefs = requireActivity().getSharedPreferences("cred", Context.MODE_PRIVATE)
                        prefs.edit().putString("Email", binding.email.text.toString())
                            .putString("Password", binding.password.text.toString()).apply()
                        requireActivity().startActivity(Intent(requireActivity(),BottomNavigationActivity::class.java))
                        requireActivity().finish()
                    }else{
                        Toast.makeText(activity,"Неверный логин или пароль",Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else{
                Toast.makeText(activity,"Вы не ввели логин или пароль",Toast.LENGTH_SHORT).show()
            }*/
/*        if (auth.currentUser != null) {
            intent = Intent(this, BottomNavigationActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_Fragment, AuthFragment())
                .commit()
        }*/

}




