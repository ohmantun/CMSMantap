package com.example.cmsmantap.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
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

        binding.apply {
            btnPilihtgl.setOnClickListener {
                val datePickerFragment = DatePickerFragment()
                val supportFragmentManager = requireActivity().supportFragmentManager

                supportFragmentManager.setFragmentResultListener(
                    "REQUEST_KEY",
                    viewLifecycleOwner
                ){
                        resultKey, bundle -> if (resultKey == "REQUEST_KEY"){
                    val date = bundle.getString("SELECTED_DATE")
                    tvTglterjadwal.text = date
                    }
                }
                //show
                datePickerFragment.show(supportFragmentManager, "DatePickerFragment")
            }
        }

        binding.btnProses.setOnClickListener {
            Toast.makeText(context,
                "Input Payroll Sukses. Menunggu Validasi Checker",
                Toast.LENGTH_LONG
            ).show()
            binding.acTvNoRekPengirim.setText("")
            binding.rgTglpembayaran.clearCheck()
            binding.etKeteranganPen.text.clear()
            binding.tvTglterjadwal.setText("")
        }

        return binding.root


    }
}