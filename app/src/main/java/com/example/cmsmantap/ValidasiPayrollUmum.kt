package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmsmantap.adapter.PayrollUmumCkrAdapter
import com.example.cmsmantap.databinding.ActivityValidasiPayrollUmumBinding
import com.example.cmsmantap.model.PayrollUmumChecker


class ValidasiPayrollUmum : AppCompatActivity() {
    private lateinit var binding : ActivityValidasiPayrollUmumBinding

    lateinit var payrollUmumCkrAdapter: PayrollUmumCkrAdapter
    val lm = object : LinearLayoutManager(this){
        override fun canScrollVertically(): Boolean {
            return false
        }
    }
    val addPayrollUmumCkrList : MutableList<PayrollUmumChecker> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValidasiPayrollUmumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, OtorisasiPayroll::class.java)
            startActivity(intent)
        }

        initView()

    }

    fun initView(){
        binding.rvDataPayrollUmum.layoutManager = lm
        payrollUmumCkrAdapter = PayrollUmumCkrAdapter(this)
        binding.rvDataPayrollUmum.adapter = payrollUmumCkrAdapter

        addPayrollUmumCkrList.add(PayrollUmumChecker(namaFile = "Payroll.CSV", tanggalPengajuan = "20/02/2020",
        tanggalEksekusi = "21/02/2020", diajukanOleh = "MAKER01", keterangan = "Testing", status = "Belum Disetujui")
        )
        addPayrollUmumCkrList.add(PayrollUmumChecker(namaFile = "Payroll.CSV", tanggalPengajuan = "20/02/2020",
            tanggalEksekusi = "21/02/2020", diajukanOleh = "MAKER01", keterangan = "Testing", status = "Belum Disetujui"))

        addPayrollUmumCkrList.add(PayrollUmumChecker(namaFile = "Payroll.CSV", tanggalPengajuan = "20/02/2020",
            tanggalEksekusi = "21/02/2020", diajukanOleh = "MAKER01", keterangan = "Testing", status = "Belum Disetujui"))

        addPayrollUmumCkrList.add(PayrollUmumChecker(namaFile = "Payroll.CSV", tanggalPengajuan = "20/02/2020",
            tanggalEksekusi = "21/02/2020", diajukanOleh = "MAKER01", keterangan = "Testing", status = "Belum Disetujui"))

        addPayrollUmumCkrList.add(PayrollUmumChecker(namaFile = "Payroll.CSV", tanggalPengajuan = "20/02/2020",
            tanggalEksekusi = "21/02/2020", diajukanOleh = "MAKER01", keterangan = "Testing", status = "Belum Disetujui"))

        payrollUmumCkrAdapter.setListDataPayrollUmumCkr(addPayrollUmumCkrList)
    }
}