package com.example.cmsmantap

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class Notifikasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_notifikasi)

        val btnBack = findViewById<ImageView>(R.id.btnBack)

        btnBack.setOnClickListener{
            val intent = Intent(this, Beranda::class.java)
            startActivity(intent)
        }
    }
}