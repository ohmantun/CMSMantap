package com.example.cmsmantap.fragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.cmsmantap.R
import com.example.cmsmantap.databinding.FragmentBuatbaruBinding
import kotlinx.android.synthetic.main.fragment_barupensiunan.*


class FragmentBuatbaru : Fragment() {
    private var _binding: FragmentBuatbaruBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBuatbaruBinding.inflate(inflater, container, false)

//        val pilihJenisTransaksi = resources.getStringArray(R.array.pilih_jenis_transaksi)
//        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, pilihJenisTransaksi)
//        binding.acTvJenisTransaksi.setAdapter(arrayAdapter)

        val pilihRekening = resources.getStringArray(R.array.pilih_rek)
        val arrAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, pilihRekening)
//        binding.acTvNoRekPengirim.setAdapter(arrAdapter)



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


        binding.btnUpload.setOnClickListener {
            Toast.makeText(context,
                "Input Payroll Sukses. Menunggu Validasi Checker",
                Toast.LENGTH_LONG
            ).show()
//            binding.acTvJenisTransaksi.setText("")
//            binding.acTvNoRekPengirim.setText("")
//            binding.rgTglpembayaran.clearCheck()
//            binding.etKeterangan.text.clear()
//            binding.tvTglterjadwal.setText("")
        }

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



    }





