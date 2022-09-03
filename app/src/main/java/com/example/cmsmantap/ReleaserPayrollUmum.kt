package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmsmantap.adapter.PayrollUmumReleaserAdapter
import com.example.cmsmantap.databinding.ActivityReleaserPayrollUmumBinding
import com.example.cmsmantap.model.PayrollUmumReleaser


class ReleaserPayrollUmum : AppCompatActivity() {
    private lateinit var binding : ActivityReleaserPayrollUmumBinding

    lateinit var payrollUmumReleaserAdapter: PayrollUmumReleaserAdapter
    val lm = LinearLayoutManager(this)
    val addPayrollUmumReleaserList : MutableList<PayrollUmumReleaser> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReleaserPayrollUmumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, ApprovelPayroll::class.java)
            startActivity(intent)
        }

        initView()

    }

    fun initView(){
        binding.rvDataPayrollUmum.layoutManager = lm
        payrollUmumReleaserAdapter = PayrollUmumReleaserAdapter(this)
        binding.rvDataPayrollUmum.adapter = payrollUmumReleaserAdapter

        addPayrollUmumReleaserList.add(
            PayrollUmumReleaser(namaFile = "Payroll.CSV", tanggalPengajuan = "20/02/2020",
            tanggalEksekusi = "21/02/2020", diajukanOleh = "MAKER01", keterangan = "Testing", status = "Belum Disetujui")
        )
        addPayrollUmumReleaserList.add(PayrollUmumReleaser(namaFile = "Payroll.CSV", tanggalPengajuan = "20/02/2020",
            tanggalEksekusi = "21/02/2020", diajukanOleh = "MAKER01", keterangan = "Testing", status = "Belum Disetujui"))

        addPayrollUmumReleaserList.add(PayrollUmumReleaser(namaFile = "Payroll.CSV", tanggalPengajuan = "20/02/2020",
            tanggalEksekusi = "21/02/2020", diajukanOleh = "MAKER01", keterangan = "Testing", status = "Belum Disetujui"))

        addPayrollUmumReleaserList.add(PayrollUmumReleaser(namaFile = "Payroll.CSV", tanggalPengajuan = "20/02/2020",
            tanggalEksekusi = "21/02/2020", diajukanOleh = "MAKER01", keterangan = "Testing", status = "Belum Disetujui"))

        addPayrollUmumReleaserList.add(PayrollUmumReleaser(namaFile = "Payroll.CSV", tanggalPengajuan = "20/02/2020",
            tanggalEksekusi = "21/02/2020", diajukanOleh = "MAKER01", keterangan = "Testing", status = "Belum Disetujui"))

        payrollUmumReleaserAdapter.setListDataPayrollUmumReleaser(addPayrollUmumReleaserList)
    }
}