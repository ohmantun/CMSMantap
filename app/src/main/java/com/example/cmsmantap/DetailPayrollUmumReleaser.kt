package com.example.cmsmantap

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmsmantap.adapter.PayrollUmumDtlReleaserAdapter
import com.example.cmsmantap.databinding.ActivityDetailPayrollUmumReleaserBinding
import com.example.cmsmantap.model.PayrollUmumRsrDetail

class DetailPayrollUmumReleaser : AppCompatActivity() {
    private lateinit var binding : ActivityDetailPayrollUmumReleaserBinding

    val lm = object : LinearLayoutManager(this) {
        override fun canScrollVertically(): Boolean {
            return false
        }
    }
    val addPayrollUmumDetailRsrList : MutableList<PayrollUmumRsrDetail> = ArrayList()
    lateinit var payrollUmumDtlReleaserAdapter: PayrollUmumDtlReleaserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailPayrollUmumReleaserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, ReleaserPayrollUmum::class.java)
            startActivity(intent)
        }

        initView()

        val btnReject = findViewById<Button>(R.id.btnReject)
        val editTextRejectNote = findViewById<EditText>(R.id.et_rejectNote)

        btnReject.setOnClickListener {
            val inputRejectNote = editTextRejectNote.text.toString()
            if (inputRejectNote.isEmpty()){
                Toast.makeText(this, "Silahkan isi Reject Note!", Toast.LENGTH_SHORT).show()
            } else {
                val dialogBinding = layoutInflater.inflate(R.layout.reject_confirm_dialog, null)

                val myDialog = Dialog(this)
                myDialog.setContentView(dialogBinding)

                myDialog.setCancelable(true)
                myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                myDialog.show()

                val btnCancel = dialogBinding.findViewById<Button>(R.id.btnCancel)
                btnCancel.setOnClickListener {
                    myDialog.cancel()
                }

                val tvStatusInfoReject = findViewById<TextView>(R.id.tv_statusPayrollUmum)
                val btnOkConfirmReject = dialogBinding.findViewById<Button>(R.id.btnRejectConfirmOK)

                btnOkConfirmReject.setOnClickListener {
                    tvStatusInfoReject.text = "DITOLAK!"
                    tvStatusInfoReject.setTextColor(Color.parseColor("#D20707"))
                    val suksesDialogBinding =
                        layoutInflater.inflate(R.layout.reject_sukses_dialog, null)

                    val suksesDialog = Dialog(this)
                    suksesDialog.setContentView(suksesDialogBinding)

                    suksesDialog.setCancelable(true)
                    suksesDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    suksesDialog.show()

                    val btnOkRejectSuskses = suksesDialogBinding.findViewById<Button>(R.id.btnOkRjtSukses)

                    btnOkRejectSuskses.setOnClickListener {
                        val btnValidasi = findViewById<Button>(R.id.btnValidasi)
                        suksesDialog.cancel()
                        myDialog.cancel()
                        btnValidasi.isEnabled=false
                        btnReject.isEnabled=false

                    }
                }
            }
        }

        val btnValidasi = findViewById<Button>(R.id.btnValidasi)

        btnValidasi.setOnClickListener {
            val intent = Intent(this, KirimOTP::class.java)
            startActivity(intent)
        }


       /* btnValidasi.setOnClickListener {
            val validasiBinding = layoutInflater.inflate(R.layout.validate_dialog, null)

            val myValidasiDialog = Dialog(this)
            myValidasiDialog.setContentView(validasiBinding)
            myValidasiDialog.setCancelable(true)
            myValidasiDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myValidasiDialog.show()

            val btnConfirmValidasi = validasiBinding.findViewById<Button>(R.id.btnAccValidasi)
            val tvStatusInfo = findViewById<TextView>(R.id.tv_statusPayrollUmum)

            btnConfirmValidasi.setOnClickListener {
                tvStatusInfo.text = "Telah Disetujui"
                tvStatusInfo.setTextColor(Color.parseColor("#00AD43"))
                val confirmBinding = layoutInflater.inflate(R.layout.validasi_sukses_dialog, null)
                val confirmDialog = Dialog(this)
                confirmDialog.setContentView(confirmBinding)
                confirmDialog.setCancelable(true)
                confirmDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                confirmDialog.show()

                val btnOkSelesai = confirmBinding.findViewById<Button>(R.id.btnOkselesai)

                btnOkSelesai.setOnClickListener {
                    confirmDialog.cancel()
                    myValidasiDialog.cancel()
                }

            }

            val btnCancelValidasi = validasiBinding.findViewById<Button>(R.id.btnCancelValidasi)
            btnCancelValidasi.setOnClickListener {
                myValidasiDialog.cancel()
            }

        }
        */

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