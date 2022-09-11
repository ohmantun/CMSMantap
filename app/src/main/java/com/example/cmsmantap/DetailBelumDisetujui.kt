package com.example.cmsmantap

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class DetailBelumDisetujui : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.dashboard_belum_disetujui)

        val spinner: Spinner = findViewById(R.id.spinner_jenis)
        val btnBack = findViewById<ImageView>(R.id.btnBack)

        ArrayAdapter.createFromResource(
                   this,
                   R.array.pilih_jenis,
                   android.R.layout.simple_spinner_item
               ).also { adapter ->
            // Specify the layout to use when the list of choices appears
                   adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            // Apply the adapter to the spinner
                  spinner.adapter = adapter
               }

        btnBack.setOnClickListener {
            val intent = Intent(this, Beranda::class.java)
            startActivity(intent)
        }


    }
}