package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class Pengaturan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_pengaturan)

      //  val btnPayrollUmum = findViewById<ImageButton>(R.id.btnPayroll_umum)
      //  val btnPayrollPensiunan = findViewById<ImageButton>(R.id.btnPayroll_pensiunan)
        val btnBack = findViewById<ImageView>(R.id.btnBack)

        btnBack.setOnClickListener{
            val intent = Intent(this, Beranda::class.java)
            startActivity(intent)
        }

    }
}