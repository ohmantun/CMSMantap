package com.example.cmsmantap

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.inputmethodservice.ExtractEditText
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmsmantap.adapter.PayrollPensiunCkrAdapter
import com.example.cmsmantap.adapter.PayrollPensiunDtlCkrAdapter
import com.example.cmsmantap.adapter.PayrollPensiunDtlReleaserAdapter
import com.example.cmsmantap.adapter.PayrollUmumDCkrAdapter
import com.example.cmsmantap.databinding.ActivityDetailPayrollPensiunCkrBinding
import com.example.cmsmantap.databinding.ActivityDetailPayrollPensiunReleaserBinding
import com.example.cmsmantap.databinding.ActivityDetailPayrollUmumBinding
import com.example.cmsmantap.model.PayrollPensiunCkrDetail
import com.example.cmsmantap.model.PayrollPensiunRsrDetail
import com.example.cmsmantap.model.PayrollUmumCkrDetail

class DetailPayrollPensiunReleaser : AppCompatActivity() {
    private lateinit var binding : ActivityDetailPayrollPensiunReleaserBinding

    val lm = LinearLayoutManager(this)
    val addPayrollPensiunDetailRsrList : MutableList<PayrollPensiunRsrDetail> = ArrayList()
    lateinit var payrollPensiunDtlReleaserAdapter: PayrollPensiunDtlReleaserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPayrollPensiunReleaserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackDtl.setOnClickListener {
            val intent = Intent(this, ReleaserPayrollPensiun::class.java)
            startActivity(intent)
        }

        initView()


        /*val btnReject = findViewById<Button>(R.id.btnReject)
        val rejectNoteDialog = AlertDialog.Builder(this)
            .setView(layoutInflater.inflate(R.layout.reject_note_dialog, null))
            .setPositiveButton("Reject") { _, _->
                Toast.makeText(this, "Payroll Pensiunan has rejected", Toast.LENGTH_SHORT).show()
            }.create()

        btnReject.setOnClickListener {
            rejectNoteDialog.show()
        }*/



        val btnReject = findViewById<Button>(R.id.btnReject)
        val etRejectNote = findViewById<ExtractEditText>(R.id.et_rejectNote)

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
            val dialogBinding = layoutInflater.inflate(R.layout.validate_dialog, null)

            val myValidasiDialog = Dialog(this)
            myValidasiDialog.setContentView(dialogBinding)

            myValidasiDialog.setCancelable(true)
            myValidasiDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myValidasiDialog.show()

            val btnCancelValidasi = dialogBinding.findViewById<Button>(R.id.btnCancelValidasi)
            btnCancelValidasi.setOnClickListener {
                myValidasiDialog.cancel()
            }

        }
    }

    fun initView(){
        binding.rvDataPayrollPensiunDtl.layoutManager = lm
        payrollPensiunDtlReleaserAdapter = PayrollPensiunDtlReleaserAdapter(this)
        binding.rvDataPayrollPensiunDtl.adapter = payrollPensiunDtlReleaserAdapter

        addPayrollPensiunDetailRsrList.add(
            PayrollPensiunRsrDetail(nmrPensiun = "93782821893", nmrRekening = "352617353",
                nama = "Rahmat Pratama", nilaiGaji = "4.500.000", keterangan = "Gaji Benar",
                statusBlokir = "0", tglDapem = "16/08/2022", tglEfektif = "16/08/2022")
        )
        addPayrollPensiunDetailRsrList.add(
            PayrollPensiunRsrDetail(nmrPensiun = "93782821893", nmrRekening = "352617353",
                nama = "Rahmat Pratama", nilaiGaji = "4.800.000", keterangan = "Gaji Benar",
                statusBlokir = "0", tglDapem = "16/08/2022", tglEfektif = "16/08/2022")
        )
        addPayrollPensiunDetailRsrList.add(
            PayrollPensiunRsrDetail(nmrPensiun = "93782821893", nmrRekening = "352617353",
                nama = "Rahmat Pratama", nilaiGaji = "4.000.000", keterangan = "Gaji Benar",
                statusBlokir = "0", tglDapem = "16/08/2022", tglEfektif = "16/08/2022")
        )
        addPayrollPensiunDetailRsrList.add(
            PayrollPensiunRsrDetail(nmrPensiun = "93782821893", nmrRekening = "352617353",
                nama = "Rahmat Pratama", nilaiGaji = "4.700.000", keterangan = "Gaji Benar",
                statusBlokir = "0", tglDapem = "16/08/2022", tglEfektif = "16/08/2022")
        )
        addPayrollPensiunDetailRsrList.add(
            PayrollPensiunRsrDetail(nmrPensiun = "93782821893", nmrRekening = "352617353",
                nama = "Rahmat Pratama", nilaiGaji = "3.500.000", keterangan = "Gaji Benar",
                statusBlokir = "0", tglDapem = "16/08/2022", tglEfektif = "16/08/2022")
        )

        payrollPensiunDtlReleaserAdapter.setListDataPayrollPensiunDtlRsr(addPayrollPensiunDetailRsrList)
    }
}