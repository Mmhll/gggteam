package com.ggg.gggapp.fragments.services

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import com.ggg.gggapp.R
import com.ggg.gggapp.database.Database
import com.ggg.gggapp.databinding.FragmentRolesBinding
import com.ggg.gggapp.dataclasses.RoleClass
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class RolesFragment : Fragment() {
    private var binding: FragmentRolesBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRolesBinding.inflate(inflater)
        var role = ""
        binding!!.radioGroup.setOnCheckedChangeListener { _, position ->
            when (position) {
                R.id.admin -> {
                    role = binding!!.admin.text.toString()
                }
                R.id.supervisor -> {
                    role = binding!!.supervisor.text.toString()
                }
                R.id.deputyHead -> {
                    role = binding!!.deputyHead.text.toString()
                }
                R.id.rsp -> {
                    role = binding!!.rsp.text.toString()
                }
                R.id.worker -> {
                    role = binding!!.worker.text.toString()
                }
                R.id.newWorker -> {
                    role = binding!!.newWorker.text.toString()
                }
                R.id.employee -> {
                    role = binding!!.newWorker.text.toString()
                }
            }
        }
        binding!!.requestButton.setOnClickListener {
            if (role.isNotEmpty()){
                var reference = FirebaseDatabase.getInstance().getReference("requests")
                var key = reference.push().key
                reference.child(key.toString()).setValue(RoleClass(Firebase.auth.uid.toString(), role)).addOnCompleteListener {
                    if (it.isSuccessful){
                        requireActivity().supportFragmentManager.beginTransaction()
                            .remove(this)
                            .commit()
                    }
                }
            }
        }
        return binding!!.root
    }

}