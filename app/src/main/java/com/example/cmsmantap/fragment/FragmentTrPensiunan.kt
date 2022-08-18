package com.example.cmsmantap.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cmsmantap.databinding.FragmentTrpensiunanBinding

class FragmentTrPensiunan : Fragment() {

    private var _binding: FragmentTrpensiunanBinding? = null
    private val binding get() = _binding!!
    //private lateinit var fragmentAdapter : FragmentAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTrpensiunanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}