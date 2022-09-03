package com.example.cmsmantap

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmsmantap.adapter.PayrollUmumDtlReleaserAdapter
import com.example.cmsmantap.databinding.ActivityDetailPayrollUmumReleaserBinding
import com.example.cmsmantap.model.PayrollUmumRsrDetail

class DetailPayrollUmumReleaser : AppCompatActivity() {
    private lateinit var binding : ActivityDetailPayrollUmumReleaserBinding

    val lm = LinearLayoutManager(this)
    val addPayrollUmumDetailRsrList : MutableList<PayrollUmumRsrDetail> = ArrayList()
    lateinit var payrollUmumDtlReleaserAdapter: PayrollUmumDtlReleaserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailPayrollUmumReleaserBinding.inflate(layoutInflater)
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

            val btnRejectConfirm = dialogBinding.findViewById<Button>(R.id.btnRejectConfirm)
            btnRejectConfirm.setOnClickListener {
                val dialogBuilder = AlertDialog.Builder(this)
                    // if the dialog is cancelable
                    .setCancelable(true)
                    // positive button text and action

                    .setView(layoutInflater.inflate(R.layout.reject_confirm_dialog,null))
                // negative button text and action
                //    .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                //            dialog, id -> dialog.cancel()
                //   })
                // create dialog box
                val alert = dialogBuilder.create()
                // show alert dialog
                alert.show()
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
        payrollUmumDtlReleaserAdapter = PayrollUmumDtlReleaserAdapter(this)
        binding.rvDataPayrollUmumD.adapter = payrollUmumDtlReleaserAdapter

        addPayrollUmumDetailRsrList.add(
            PayrollUmumRsrDetail(tglTransaksi = "23/02/2020", rekSumber = "1231413",
                rekPenerima = "8123818", nominal = "4.500.000", keteranganD = "Testing")
        )
        addPayrollUmumDetailRsrList.add(
            PayrollUmumRsrDetail(tglTransaksi = "23/02/2020", rekSumber = "1231413",
                rekPenerima = "8123818", nominal = "6.500.000", keteranganD = "Testing")
        )
        addPayrollUmumDetailRsrList.add(
            PayrollUmumRsrDetail(tglTransaksi = "23/02/2020", rekSumber = "1231413",
                rekPenerima = "8123818", nominal = "5.500.000", keteranganD = "Testing")
        )
        addPayrollUmumDetailRsrList.add(
            PayrollUmumRsrDetail(tglTransaksi = "23/02/2020", rekSumber = "1231413",
                rekPenerima = "8123818", nominal = "4.500.000", keteranganD = "Testing")
        )
        addPayrollUmumDetailRsrList.add(
            PayrollUmumRsrDetail(tglTransaksi = "23/02/2020", rekSumber = "1231413",
                rekPenerima = "8123818", nominal = "3.500.000", keteranganD = "Testing")
        )

        payrollUmumDtlReleaserAdapter.setListDataPayrollUmumDtlRsr(addPayrollUmumDetailRsrList)
    }
}