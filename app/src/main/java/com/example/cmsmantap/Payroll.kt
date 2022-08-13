package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.cmsmantap.data.PayrollUmum

class Payroll : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_payroll)

        val btnPayrollUmum = findViewById<ImageButton>(R.id.btnPayroll_umum)
        val btnPayrollPensiunan = findViewById<ImageButton>(R.id.btnPayroll_pensiunan)
        val btnBackpayroll = findViewById<ImageButton>(R.id.btnBackpayroll)

        btnBackpayroll.setOnClickListener {
            val intent = Intent(this, Beranda::class.java)
            startActivity(intent)
        }

        btnPayrollUmum.setOnClickListener{
            val intent = Intent(this, PayrollUmum::class.java)
            startActivity(intent)
        }

        btnPayrollPensiunan.setOnClickListener{
            val intent = Intent(this, PayrollPensiunan::class.java)
            startActivity(intent)
        }


    }
}