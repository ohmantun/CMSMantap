package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmsmantap.adapter.PayrollPensiunCkrAdapter
import com.example.cmsmantap.databinding.ActivityValidasiPayrollPensiunBinding
import com.example.cmsmantap.model.PayrollPensiunCkr

class ValidasiPayrollPensiun : AppCompatActivity() {
    private lateinit var binding: ActivityValidasiPayrollPensiunBinding

    lateinit var payrollPensiunCkrAdapter: PayrollPensiunCkrAdapter
    val lm = object : LinearLayoutManager(this){
        override fun canScrollVertically(): Boolean {
            return false
        }
    }
    val addPayrollPensiunCkrList : MutableList<PayrollPensiunCkr> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValidasiPayrollPensiunBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackPen.setOnClickListener {
            val intent = Intent(this, OtorisasiPayroll::class.java)
            startActivity(intent)
        }

        initView()
    }

    fun initView() {
        binding.rvDataPayrollPensiun.layoutManager = lm
        payrollPensiunCkrAdapter = PayrollPensiunCkrAdapter(this)
        binding.rvDataPayrollPensiun.adapter = payrollPensiunCkrAdapter


        addPayrollPensiunCkrList.add(
            PayrollPensiunCkr(namaFile = "Payroll Pensiun.CSV", proses = "Pengajuan",
            rekeningSumber = "1273612637 TABUNGAN SIMANTAP", diajukanOleh = "DRMAKER01",
            jadwalTransaksi = "Transaksi sekarang - 16/08/2022", status = "Belum Disetujui")
        )

        addPayrollPensiunCkrList.add(PayrollPensiunCkr(namaFile = "Payroll Pensiun.CSV", proses = "Pengajuan",
            rekeningSumber = "1273612637 TABUNGAN SIMANTAP", diajukanOleh = "DRMAKER01",
            jadwalTransaksi = "Transaksi sekarang - 16/08/2022", status = "Belum Disetujui")
        )

        addPayrollPensiunCkrList.add(PayrollPensiunCkr(namaFile = "Payroll Pensiun.CSV", proses = "Pengajuan",
            rekeningSumber = "1273612637 TABUNGAN SIMANTAP", diajukanOleh = "DRMAKER01",
            jadwalTransaksi = "Transaksi sekarang - 16/08/2022", status = "Belum Disetujui")
        )

        addPayrollPensiunCkrList.add(PayrollPensiunCkr(namaFile = "Payroll Pensiun.CSV", proses = "Pengajuan",
            rekeningSumber = "1273612637 TABUNGAN SIMANTAP", diajukanOleh = "DRMAKER01",
            jadwalTransaksi = "Transaksi sekarang - 16/08/2022", status = "Belum Disetujui")
        )

        addPayrollPensiunCkrList.add(PayrollPensiunCkr(namaFile = "Payroll Pensiun.CSV", proses = "Pengajuan",
            rekeningSumber = "1273612637 TABUNGAN SIMANTAP", diajukanOleh = "DRMAKER01",
            jadwalTransaksi = "Transaksi sekarang - 16/08/2022", status = "Belum Disetujui")
        )

        payrollPensiunCkrAdapter.setListDataPayrollPensiunCkr(addPayrollPensiunCkrList)

    }

}