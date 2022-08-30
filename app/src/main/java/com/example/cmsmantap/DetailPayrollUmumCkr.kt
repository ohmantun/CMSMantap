package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmsmantap.adapter.PayrollUmumCkrAdapter
import com.example.cmsmantap.adapter.PayrollUmumDCkrAdapter
import com.example.cmsmantap.databinding.ActivityDetailPayrollUmumBinding
import com.example.cmsmantap.model.PayrollUmumChecker
import com.example.cmsmantap.model.PayrollUmumCkrDetail

class DetailPayrollUmumCkr : AppCompatActivity() {
    private lateinit var binding : ActivityDetailPayrollUmumBinding

    val lm = LinearLayoutManager(this)
    val addPayrollUmumDetailCkrList : MutableList<PayrollUmumCkrDetail> = ArrayList()
    lateinit var payrollUmumDCkrAdapter: PayrollUmumDCkrAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPayrollUmumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, ValidasiPayrollUmum::class.java)
            startActivity(intent)
        }

        initView()


    }


    fun initView(){
        binding.rvDataPayrollUmumD.layoutManager = lm
        payrollUmumDCkrAdapter = PayrollUmumDCkrAdapter(this)
        binding.rvDataPayrollUmumD.adapter = payrollUmumDCkrAdapter

        addPayrollUmumDetailCkrList.add(
            PayrollUmumCkrDetail(tglTransaksi = "23/02/2020", rekSumber = "1231413",
            rekPenerima = "8123818", nominal = "4.500.000", keteranganD = "Testing")
        )
        addPayrollUmumDetailCkrList.add(
            PayrollUmumCkrDetail(tglTransaksi = "23/02/2020", rekSumber = "1231413",
                rekPenerima = "8123818", nominal = "6.500.000", keteranganD = "Testing")
        )
        addPayrollUmumDetailCkrList.add(
            PayrollUmumCkrDetail(tglTransaksi = "23/02/2020", rekSumber = "1231413",
                rekPenerima = "8123818", nominal = "5.500.000", keteranganD = "Testing")
        )
        addPayrollUmumDetailCkrList.add(
            PayrollUmumCkrDetail(tglTransaksi = "23/02/2020", rekSumber = "1231413",
                rekPenerima = "8123818", nominal = "4.500.000", keteranganD = "Testing")
        )
        addPayrollUmumDetailCkrList.add(
            PayrollUmumCkrDetail(tglTransaksi = "23/02/2020", rekSumber = "1231413",
                rekPenerima = "8123818", nominal = "3.500.000", keteranganD = "Testing")
        )

        payrollUmumDCkrAdapter.setListDataPayrollUmumDCkr(addPayrollUmumDetailCkrList)
    }
}