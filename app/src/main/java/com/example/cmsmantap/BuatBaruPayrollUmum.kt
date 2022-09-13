package com.example.cmsmantap.data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class BuatBaruPayrollUmum : AppCompatActivity(), MakerAdapter.HomeListener {
    private lateinit var vm: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.fragment_buatbaru)
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

}