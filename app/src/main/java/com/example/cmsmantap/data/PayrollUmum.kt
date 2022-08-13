package com.example.cmsmantap.data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.cmsmantap.Beranda
import com.example.cmsmantap.R

class PayrollUmum : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_payroll_umum)

        val rgTglPembayaran = findViewById<RadioGroup>(R.id.rgTglpembayaran)
        val btnCancel = findViewById<Button>(R.id.btnCancel)
        val btnUpload = findViewById<Button>(R.id.btnUpload)
        val btnBack = findViewById<ImageView>(R.id.btnBack)

        btnBack.setOnClickListener {
            val intent = Intent(this,Beranda::class.java)
            startActivity(intent)
        }

        btnUpload.setOnClickListener{

            val cekTglPembayaranRadioButton = rgTglPembayaran.checkedRadioButtonId
            val tglPembayaran = findViewById<RadioButton>(cekTglPembayaranRadioButton)

            if (rgTglPembayaran == null){
                Toast.makeText(this@PayrollUmum,
                "Harap pilih salah satu tanggal pembayaran gaji",
                Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(this@PayrollUmum,
                "Upload Berhasil!",
                Toast.LENGTH_SHORT
                ).show()
            }

        }



        val spinner: Spinner = findViewById(R.id.spinner_jenis_trx)

        ArrayAdapter.createFromResource(
            this,
            R.array.pilih_jenis_transaksi,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

    }

}