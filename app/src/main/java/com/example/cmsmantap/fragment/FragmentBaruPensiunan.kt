package com.example.cmsmantap.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.cmsmantap.R
import com.example.cmsmantap.databinding.FragmentBarupensiunanBinding

class FragmentBaruPensiunan : Fragment() {
    private var _binding: FragmentBarupensiunanBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBarupensiunanBinding.inflate(inflater, container, false)

        val pilihRekening = resources.getStringArray(R.array.pilih_rek)
        val arrAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, pilihRekening)
        binding.acTvNoRekPengirim.setAdapter(arrAdapter)

        return binding.root


    }
}