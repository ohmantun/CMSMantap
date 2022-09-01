package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class OtorisasiPayroll : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otorisasi_payroll)

        val btnPayrollUmumChecker = findViewById<ImageButton>(R.id.btnPayroll_umum)
        val btnPayrollPensiunan = findViewById<ImageButton>(R.id.btnPayroll_pensiunan)
        val btnBackpayrollCkr = findViewById<ImageButton>(R.id.btnBackpayrollCkr)

        btnBackpayrollCkr.setOnClickListener {
            val intent = Intent(this, Beranda_Cheker::class.java)
            startActivity(intent)
        }

        btnPayrollUmumChecker.setOnClickListener {
            val intent = Intent(this, ValidasiPayrollUmum::class.java)
            startActivity(intent)
        }

        btnPayrollPensiunan.setOnClickListener {
            val intent = Intent(this, ValidasiPayrollPensiun::class.java)
            startActivity(intent)
        }


    }
}