package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.cmsmantap.data.LoginActivity

class Pengaturan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_pengaturan)

      //  val btnPayrollUmum = findViewById<ImageButton>(R.id.btnPayroll_umum)
      //  val btnPayrollPensiunan = findViewById<ImageButton>(R.id.btnPayroll_pensiunan)
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val btnGantiSandi = findViewById<CardView>(R.id.btnGantiSandi)

        btnBack.setOnClickListener{
            val intent = Intent(this, Beranda::class.java)
            startActivity(intent)
        }

        btnGantiSandi.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java) //Login Activity ganti ke page sandinya
            startActivity(intent)
        }

    }
}