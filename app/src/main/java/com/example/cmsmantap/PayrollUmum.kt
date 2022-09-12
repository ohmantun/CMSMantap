package com.example.cmsmantap.data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmsmantap.Payroll
import com.example.cmsmantap.R
import com.example.cmsmantap.databinding.ActivityPayrollUmumBinding
import com.example.cmsmantap.fragment.FragmentAdapter
import com.example.cmsmantap.ui.MakerAdapter
import com.example.cmsmantap.viewmodel.HomeViewModel
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*


class PayrollUmum : AppCompatActivity(), MakerAdapter.HomeListener {
    private lateinit var vm:HomeViewModel
    private lateinit var adapter: MakerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        initAdapter()

        vm.fetchAllTransaksiMakerUmum()

        vm.MakerModelListLiveData?.observe(this, Observer {
            if (it!=null){
                rv_home.visibility = View.VISIBLE
                adapter.setData(it as ArrayList<MakerModel>)
            }else{
                showToast("Something went wrong")
            }
//            progress_home.visibility = View.GONE
        })

       /* btnUpload.setOnClickListener{

            val cekTglPembayaranRadioButton = rgTglPembayaran.checkedRadioButtonId
            val tglPembayaran = findViewById<RadioButton>(cekTglPembayaranRadioButton)

            if (rgTglPembayaran == null){
                Toast.makeText(this@PayrollUmum,
                    "Harap pilih salah satu tanggal pembayaran gaji",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(this@PayrollUmum,
                    "Upload Berhasil!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }*/

    }

    private fun initAdapter() {
        adapter = MakerAdapter(this)
        rv_home.layoutManager = LinearLayoutManager(this)
        rv_home.adapter = adapter
    }

    private fun showToast(msg:String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

}