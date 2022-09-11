package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmsmantap.adapter.PayrollPensiunReleaserAdapter
import com.example.cmsmantap.databinding.ActivityReleaserPayrollPensiunBinding
import com.example.cmsmantap.model.PayrollPensiunReleaser


class ReleaserPayrollPensiun : AppCompatActivity() {
    private lateinit var binding: ActivityReleaserPayrollPensiunBinding

    lateinit var payrollPensiunReleaserAdapter: PayrollPensiunReleaserAdapter
    val lm = object : LinearLayoutManager(this) {
        override fun canScrollVertically(): Boolean {
            return false
        }
    }
    val addPayrollPensiunRsrList : MutableList<PayrollPensiunReleaser> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReleaserPayrollPensiunBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackPen.setOnClickListener {
            val intent = Intent(this, ApprovelPayroll::class.java)
            startActivity(intent)
        }

        initView()
    }

    fun initView() {
        binding.rvDataPayrollPensiun.layoutManager = lm
        payrollPensiunReleaserAdapter = PayrollPensiunReleaserAdapter(this)
        binding.rvDataPayrollPensiun.adapter = payrollPensiunReleaserAdapter


        addPayrollPensiunRsrList.add(
            PayrollPensiunReleaser(namaFile = "Payroll Pensiun.CSV",
                proses = "Pengajuan",
                rekeningSumber = "1273237 SIMANTAP GOLD",
                diajukanOleh = "DRMAKER01",
                jadwalTransaksi = "Transaksi sekarang - 16/08/2022",
                status = "Belum Disetujui")
        )

        addPayrollPensiunRsrList.add(PayrollPensiunReleaser(namaFile = "Payroll Pensiun.CSV", proses = "Pengajuan",
            rekeningSumber = "1273612637 TABUNGAN SIMANTAP", diajukanOleh = "DRMAKER01",
            jadwalTransaksi = "Transaksi sekarang - 16/08/2022", status = "Belum Disetujui")
        )

        addPayrollPensiunRsrList.add(PayrollPensiunReleaser(namaFile = "Payroll Pensiun.CSV", proses = "Pengajuan",
            rekeningSumber = "1273612637 TABUNGAN SIMANTAP", diajukanOleh = "DRMAKER01",
            jadwalTransaksi = "Transaksi sekarang - 16/08/2022", status = "Belum Disetujui")
        )

        addPayrollPensiunRsrList.add(PayrollPensiunReleaser(namaFile = "Payroll Pensiun.CSV", proses = "Pengajuan",
            rekeningSumber = "1273612637 TABUNGAN SIMANTAP", diajukanOleh = "DRMAKER01",
            jadwalTransaksi = "Transaksi sekarang - 16/08/2022", status = "Belum Disetujui")
        )

        addPayrollPensiunRsrList.add(PayrollPensiunReleaser(namaFile = "Payroll Pensiun.CSV", proses = "Pengajuan",
            rekeningSumber = "1273612637 TABUNGAN SIMANTAP", diajukanOleh = "DRMAKER01",
            jadwalTransaksi = "Transaksi sekarang - 16/08/2022", status = "Belum Disetujui")
        )

        payrollPensiunReleaserAdapter.setListDataPayrollPensiunRsr(addPayrollPensiunRsrList)

    }

}