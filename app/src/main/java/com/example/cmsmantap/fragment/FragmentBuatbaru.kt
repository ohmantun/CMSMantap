package com.example.cmsmantap.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.cmsmantap.R
import com.example.cmsmantap.databinding.FragmentBuatbaruBinding


class FragmentBuatbaru : Fragment() {
    private var _binding: FragmentBuatbaruBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBuatbaruBinding.inflate(inflater, container, false)

        val pilihJenisTransaksi = resources.getStringArray(R.array.pilih_jenis_transaksi)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, pilihJenisTransaksi)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        val pilihRekening = resources.getStringArray(R.array.pilih_rek)
        val arrAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, pilihRekening)
        binding.acTvNoRekPengirim.setAdapter(arrAdapter)

        return binding.root

        //val rgTglPembayaran = resources.getLayout(R.id.rgTglpembayaran)


        /*binding.btnUpload.setOnClickListener {
            if (binding.rgTglpembayaran == null){
                Toast.makeText(context,
                    "Harap pilih salah satu tanggal pembayaran gaji",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(context,
                    "Upload Berhasil!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }*/
    }


        //val rgTglPembayaran = findViewById<RadioGroup>(R.id.rgTglpembayaran)
        //val btnCancel = findViewById<Button>(R.id.btnCancel)
        //val btnUpload = findViewById<Button>(R.id.btnUpload)


    }





