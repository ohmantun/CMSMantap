package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmsmantap.adapter.PayrollUmumCkrAdapter
import com.example.cmsmantap.data.MakerModel
import com.example.cmsmantap.databinding.ActivityValidasiPayrollUmumBinding
import com.example.cmsmantap.model.PayrollUmumChecker
import com.example.cmsmantap.ui.CheckerAdapter
import com.example.cmsmantap.ui.MakerAdapter
import com.example.cmsmantap.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*


class ValidasiPayrollUmum : AppCompatActivity(), CheckerAdapter.HomeListener {
    private lateinit var binding : ActivityValidasiPayrollUmumBinding
    private lateinit var vm: HomeViewModel
    private lateinit var adapter: CheckerAdapter

    lateinit var payrollUmumCkrAdapter: PayrollUmumCkrAdapter
    val lm = object : LinearLayoutManager(this){
        override fun canScrollVertically(): Boolean {
            return false
        }
    }
    val addPayrollUmumCkrList : MutableList<PayrollUmumChecker> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        initAdapter()

        vm.fetchAllTransaksiCheckerUmum()

        vm.MakerModelListLiveData?.observe(this, Observer {
            if (it!=null){
                rv_home.visibility = View.VISIBLE
                adapter.setData(it as ArrayList<MakerModel>)
            }else{
                showToast("Something went wrong")
            }
//            progress_home.visibility = View.GONE
        })

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

    private fun initAdapter() {
        adapter = CheckerAdapter(this)
        rv_home.layoutManager = LinearLayoutManager(this)
        rv_home.adapter = adapter
    }

    private fun showToast(msg:String){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }
}