package com.ggg.gggapp.fragments.services

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ggg.gggapp.R
import com.ggg.gggapp.databinding.FragmentWorkTimeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WorkTimeFragment : Fragment() {

    private var binding : FragmentWorkTimeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkTimeBinding.inflate(layoutInflater)
        return binding!!.root
    }
}