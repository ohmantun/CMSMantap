package com.example.cmsmantap.data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.cmsmantap.R
import com.example.cmsmantap.ui.MakerAdapter
import com.example.cmsmantap.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_buatbaru.*


class BuatBaruPayrollUmum : AppCompatActivity(), MakerAdapter.HomeListener {
    private lateinit var vm: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.fragment_buatbaru)
        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        btnUpload.setOnClickListener {

        }
    }

}