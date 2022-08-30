package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmsmantap.adapter.PayrollPensiunCkrAdapter
import com.example.cmsmantap.adapter.PayrollPensiunDtlCkrAdapter
import com.example.cmsmantap.adapter.PayrollUmumDCkrAdapter
import com.example.cmsmantap.databinding.ActivityDetailPayrollPensiunCkrBinding
import com.example.cmsmantap.databinding.ActivityDetailPayrollUmumBinding
import com.example.cmsmantap.model.PayrollPensiunCkrDetail
import com.example.cmsmantap.model.PayrollUmumCkrDetail

class DetailPayrollPensiunCkr : AppCompatActivity() {
    private lateinit var binding : ActivityDetailPayrollPensiunCkrBinding

    val lm = LinearLayoutManager(this)
    val addPayrollPensiunDetailCkrList : MutableList<PayrollPensiunCkrDetail> = ArrayList()
    lateinit var payrollPensiunDtlCkrAdapter: PayrollPensiunDtlCkrAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPayrollPensiunCkrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackDtl.setOnClickListener {
            val intent = Intent(this, ValidasiPayrollPensiun::class.java)
            startActivity(intent)
        }

        initView()
    }

    fun initView(){
        binding.rvDataPayrollPensiunDtl.layoutManager = lm
        payrollPensiunDtlCkrAdapter = PayrollPensiunDtlCkrAdapter(this)
        binding.rvDataPayrollPensiunDtl.adapter = payrollPensiunDtlCkrAdapter

        addPayrollPensiunDetailCkrList.add(
            PayrollPensiunCkrDetail(nmrPensiun = "93782821893", nmrRekening = "352617353",
                nama = "Rahmat Pratama", nilaiGaji = "4.500.000", keterangan = "Gaji Benar",
                statusBlokir = "0", tglDapem = "16/08/2022", tglEfektif = "16/08/2022")
        )
        addPayrollPensiunDetailCkrList.add(
            PayrollPensiunCkrDetail(nmrPensiun = "93782821893", nmrRekening = "352617353",
                nama = "Rahmat Pratama", nilaiGaji = "4.800.000", keterangan = "Gaji Benar",
                statusBlokir = "0", tglDapem = "16/08/2022", tglEfektif = "16/08/2022")
        )
        addPayrollPensiunDetailCkrList.add(
            PayrollPensiunCkrDetail(nmrPensiun = "93782821893", nmrRekening = "352617353",
                nama = "Rahmat Pratama", nilaiGaji = "4.000.000", keterangan = "Gaji Benar",
                statusBlokir = "0", tglDapem = "16/08/2022", tglEfektif = "16/08/2022")
        )
        addPayrollPensiunDetailCkrList.add(
            PayrollPensiunCkrDetail(nmrPensiun = "93782821893", nmrRekening = "352617353",
                nama = "Rahmat Pratama", nilaiGaji = "4.700.000", keterangan = "Gaji Benar",
                statusBlokir = "0", tglDapem = "16/08/2022", tglEfektif = "16/08/2022")
        )
        addPayrollPensiunDetailCkrList.add(
            PayrollPensiunCkrDetail(nmrPensiun = "93782821893", nmrRekening = "352617353",
                nama = "Rahmat Pratama", nilaiGaji = "3.500.000", keterangan = "Gaji Benar",
                statusBlokir = "0", tglDapem = "16/08/2022", tglEfektif = "16/08/2022")
        )

        payrollPensiunDtlCkrAdapter.setListDataPayrollPensiunDtlCkr(addPayrollPensiunDetailCkrList)
    }
}