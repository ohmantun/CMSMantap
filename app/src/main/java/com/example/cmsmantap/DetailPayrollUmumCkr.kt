package com.example.cmsmantap

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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

        val btnReject = findViewById<Button>(R.id.btnReject)

        btnReject.setOnClickListener {
            val dialogBinding = layoutInflater.inflate(R.layout.reject_note_dialog, null)

            val myDialog = Dialog(this)
            myDialog.setContentView(dialogBinding)

            myDialog.setCancelable(true)
            myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myDialog.show()

            val btnCancel = dialogBinding.findViewById<Button>(R.id.btnCancel)
            btnCancel.setOnClickListener {
                myDialog.cancel()
            }

        }

        val btnValidasi = findViewById<Button>(R.id.btnValidasi)

        btnValidasi.setOnClickListener {
            val validasiBinding = layoutInflater.inflate(R.layout.validate_dialog, null)

            val myValidasiDialog = Dialog(this)
            myValidasiDialog.setContentView(validasiBinding)
            myValidasiDialog.setCancelable(true)
            myValidasiDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myValidasiDialog.show()

            val btnCancelValidasi = validasiBinding.findViewById<Button>(R.id.btnCancelValidasi)
            btnCancelValidasi.setOnClickListener {
                myValidasiDialog.cancel()
            }
        }

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