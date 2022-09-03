package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ApprovelPayroll : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payroll_releaser)

        val btnPayrollUmumReleaser = findViewById<ImageButton>(R.id.btnPayroll_umum)
        val btnPayrollPensiunanReleaser = findViewById<ImageButton>(R.id.btnPayroll_pensiunan)
        val btnBackpayrollCkr = findViewById<ImageButton>(R.id.btnBackpayrollCkr)

        btnBackpayrollCkr.setOnClickListener {
            val intent = Intent(this, Beranda_Releaser::class.java)
            startActivity(intent)
        }

        btnPayrollUmumReleaser.setOnClickListener {
            val intent = Intent(this, ReleaserPayrollUmum::class.java)
            startActivity(intent)
        }

        btnPayrollPensiunanReleaser.setOnClickListener {
            val intent = Intent(this, ReleaserPayrollPensiun::class.java)
            startActivity(intent)
        }


    }
}