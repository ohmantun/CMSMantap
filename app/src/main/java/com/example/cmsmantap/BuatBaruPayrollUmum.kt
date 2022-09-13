package com.example.cmsmantap.data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cmsmantap.R
import com.example.cmsmantap.ui.MakerAdapter
import kotlinx.android.synthetic.main.fragment_buatbaru.*


class BuatBaruPayrollUmum : AppCompatActivity(), MakerAdapter.HomeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.fragment_buatbaru)

        btnUpload.setOnClickListener {
        }
    }

}