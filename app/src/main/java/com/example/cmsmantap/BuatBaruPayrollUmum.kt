package com.example.cmsmantap.data

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cmsmantap.Beranda
import com.example.cmsmantap.Beranda_Cheker
import com.example.cmsmantap.Beranda_Releaser
import com.example.cmsmantap.R
import com.example.cmsmantap.ui.MakerAdapter
import com.example.cmsmantap.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_buatbaru.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class BuatBaruPayrollUmum : AppCompatActivity(), MakerAdapter.HomeListener {
    private lateinit var vm: HomeViewModel

    var button_date: Button? = null
    var textview_date: TextView? = null
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.fragment_buatbaru)

        // function buat datepicker

        // get the references from layout file
        textview_date = this.et_tglPembayaranGaji
        button_date = this.button_date_1

        textview_date!!.text = "----/--/--"

        // create an OnDateSetListener
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        button_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@BuatBaruPayrollUmum,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

        // end function buat date picker


        vm = ViewModelProvider(this)[HomeViewModel::class.java]
        val inputJenisTransaksi = findViewById<TextView>(R.id.et_jenisTransaksi)
        val inputNoRekPengirim = findViewById<TextView>(R.id.et_noRekPengirim)
        val inputKeterangan = findViewById<TextView>(R.id.et_keterangan)
        val inputTanggalPembayaranGaji = findViewById<TextView>(R.id.et_tglPembayaranGaji)

        btnUpload.setOnClickListener {
            val jenisTransaksi = inputJenisTransaksi.text.toString()
            val noRekPengirim = inputNoRekPengirim.text.toString()
            val keterangan = inputKeterangan.text.toString()
            val inputTanggalPembayaranGaji = inputTanggalPembayaranGaji.text.toString()

            // get current date
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val formatted = current.format(formatter)

            val makerModel = MakerModel()
            makerModel.jenis_rekening = "Bank Mandiri Taspen"
            makerModel.nomor_rekening = noRekPengirim.toInt()
            makerModel.keterangan = keterangan
            makerModel.tanggal_eksekusi = inputTanggalPembayaranGaji
            makerModel.tanggal_pengajuan = formatted
            makerModel.maker = "Maker001"
            makerModel.status_maker = "Diajukan"
            makerModel.status_checker = "Belum Disetujui"
            makerModel.status_releaser = "Belum Disetujui"


            vm.createTransaksiMaker(makerModel)
            vm.createTransaksiMakerLiveData?.observe(this, Observer {
                Log.d("Input payroll maker umum",it.toString())
                if (it!=null){
                    val intent = Intent(this, PayrollUmum::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this, "Terjadi Kesalahan pada Sistem", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    private fun updateDateInView() {
        val myFormat = "yyyy-MM-dd" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textview_date!!.text = sdf.format(cal.getTime())
    }

}