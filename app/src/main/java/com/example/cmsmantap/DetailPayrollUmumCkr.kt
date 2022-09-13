package com.example.cmsmantap

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmsmantap.adapter.PayrollUmumDCkrAdapter
import com.example.cmsmantap.data.MakerModel
import com.example.cmsmantap.data.PayrollUmum
import com.example.cmsmantap.databinding.ActivityDetailPayrollUmumBinding
import com.example.cmsmantap.model.PayrollUmumCkrDetail
import com.example.cmsmantap.viewmodel.HomeViewModel

class DetailPayrollUmumCkr : AppCompatActivity() {
    private lateinit var binding : ActivityDetailPayrollUmumBinding
    private lateinit var vm: HomeViewModel

    val lm = object : LinearLayoutManager(this){
        override fun canScrollVertically(): Boolean {
            return false
        }
    }
    val addPayrollUmumDetailCkrList : MutableList<PayrollUmumCkrDetail> = ArrayList()
    lateinit var payrollUmumDCkrAdapter: PayrollUmumDCkrAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val payroll_id=intent.getIntExtra("id",0)
        // Log.d("payrollid",payroll_id.toString())

        binding = ActivityDetailPayrollUmumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, ValidasiPayrollUmum::class.java)
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

                val tvStatusInfoReject = findViewById<TextView>(R.id.tv_statusValidasi)
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

                    val btnOkRejectSuskses =
                        suksesDialogBinding.findViewById<Button>(R.id.btnOkRjtSukses)

                    btnOkRejectSuskses.setOnClickListener {
                        val makerModel = MakerModel()
                        makerModel.payroll_id = payroll_id
                        makerModel.status_maker = "Rejected"
                        makerModel.status_checker = "Rejected"
                        makerModel.status_releaser = "Rejected"
                        makerModel.keterangan = inputRejectNote

                        vm.updateTransaksiChecker(makerModel)
                        vm.updateTransaksiCheckerLiveData?.observe(this, Observer {
                            Log.d("Update status checker umum",it.toString())
                            if (it!=null){
                                val intent = Intent(this, ValidasiPayrollUmum::class.java)
                                startActivity(intent)
                                finish()
                            }else{
                                Toast.makeText(this, "Terjadi Kesalahan pada Sistem", Toast.LENGTH_SHORT).show()
                            }
                        })
                    }
                }
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

            val btnConfirmValidasi = validasiBinding.findViewById<Button>(R.id.btnAccValidasi)
            val tvStatusInfo = findViewById<TextView>(R.id.tv_statusValidasi)

            btnConfirmValidasi.setOnClickListener {
                tvStatusInfo.text = "Menunggu Persetujuan Releaser"
                tvStatusInfo.setTextColor(Color.parseColor("#E8CE48"))
                val confirmBinding = layoutInflater.inflate(R.layout.validasi_sukses_dialog, null)
                val confirmDialog = Dialog(this)
                confirmDialog.setContentView(confirmBinding)
                confirmDialog.setCancelable(true)
                confirmDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                confirmDialog.show()

                val btnOkSelesai = confirmBinding.findViewById<Button>(R.id.btnOkselesai)

                btnOkSelesai.setOnClickListener {
                    val makerModel = MakerModel()
                    makerModel.payroll_id = payroll_id
                    makerModel.status_maker = "Approved by Checker"
                    makerModel.status_checker = "Approved by Checker"
                    makerModel.status_releaser = "Approved by Checker"

                    vm.updateTransaksiChecker(makerModel)
                    vm.updateTransaksiCheckerLiveData?.observe(this, Observer {
                        Log.d("Update status checker umum",it.toString())
                        if (it!=null){
                            val intent = Intent(this, ValidasiPayrollUmum::class.java)
                            startActivity(intent)
                            finish()
                        }else{
                            Toast.makeText(this, "Terjadi Kesalahan pada Sistem", Toast.LENGTH_SHORT).show()
                        }
                    })
                }

            }

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