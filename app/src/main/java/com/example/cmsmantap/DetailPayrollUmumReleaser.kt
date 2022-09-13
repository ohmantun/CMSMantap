package com.example.cmsmantap

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmsmantap.adapter.PayrollUmumDtlReleaserAdapter
import com.example.cmsmantap.data.MakerModel
import com.example.cmsmantap.databinding.ActivityDetailPayrollUmumReleaserBinding
import com.example.cmsmantap.model.PayrollUmumRsrDetail
import com.example.cmsmantap.viewmodel.HomeViewModel

class DetailPayrollUmumReleaser : AppCompatActivity() {
    private lateinit var binding : ActivityDetailPayrollUmumReleaserBinding
    private lateinit var vm: HomeViewModel

    val lm = object : LinearLayoutManager(this) {
        override fun canScrollVertically(): Boolean {
            return false
        }
    }
    val addPayrollUmumDetailRsrList : MutableList<PayrollUmumRsrDetail> = ArrayList()
    lateinit var payrollUmumDtlReleaserAdapter: PayrollUmumDtlReleaserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val payroll_id=intent.getIntExtra("id",0)

        binding = ActivityDetailPayrollUmumReleaserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // vm
        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, ReleaserPayrollUmum::class.java)
            startActivity(intent)
        }

        initView()

        val tv_statusValidasiChecker = findViewById<TextView>(R.id.tv_statusPayrollUmum)
        val imageDetailReleaser = findViewById<ImageView>(R.id.imageDetailReleaser)

        val status_checker=intent.getStringExtra("status_checker")
        // change text status detail validasi checker
        if (status_checker == "Approved by Checker"){
            tv_statusValidasiChecker.text = "Menunggu Persetujuan Releaser"
            imageDetailReleaser.setImageResource(R.drawable.checklist)
        } else if (status_checker == "Approved") {
            tv_statusValidasiChecker.text = "Telah Disetujui"
            tv_statusValidasiChecker.setTextColor(Color.parseColor("#00AD43"))
            imageDetailReleaser.setImageResource(R.drawable.successcheck)
        } else if (status_checker == "Rejected") {
            tv_statusValidasiChecker.text = "Belum Disetujui"
            tv_statusValidasiChecker.setTextColor(Color.parseColor("#B22222"))
            imageDetailReleaser.setImageResource(R.drawable.cross)
        } else {
            tv_statusValidasiChecker.text = "Menunggu Diproses"
            imageDetailReleaser.setImageResource(R.drawable.checklist)
        }

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
                        val makerModel = MakerModel()
                        makerModel.payroll_id = payroll_id
                        makerModel.status_maker = "Rejected"
                        makerModel.status_checker = "Rejected"
                        makerModel.status_releaser = "Rejected"
                        makerModel.keterangan = inputRejectNote

                        vm.updateTransaksiReleaser(makerModel)
                        vm.updateTransaksiReleaserLiveData?.observe(this, Observer {
                            Log.d("Update status releaser umum",it.toString())
                            if (it!=null){
                                val intent = Intent(this, ReleaserPayrollUmum::class.java)
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
            val intent = Intent(this, KirimOTP::class.java)
            intent.putExtra("id",payroll_id)
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