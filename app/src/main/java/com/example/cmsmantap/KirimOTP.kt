package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class KirimOTP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_kirim_otp)
        val payroll_id=intent.getIntExtra("id",0)

        val btnKirimOTP = findViewById<Button>(R.id.kirimOTP)

        btnKirimOTP.setOnClickListener {
            val intent = Intent(this, InputOTP::class.java)
            intent.putExtra("id",payroll_id)
            startActivity(intent)
        }

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener(){
            onBackPressed()
        }

    }
}