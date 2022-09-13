package com.example.cmsmantap.data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmsmantap.Payroll
import com.example.cmsmantap.R
import com.example.cmsmantap.databinding.ActivityPayrollUmumBinding
import com.example.cmsmantap.fragment.FragmentAdapter
import com.example.cmsmantap.ui.MakerAdapter
import com.example.cmsmantap.viewmodel.HomeViewModel
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*


class BuatBaruPayrollUmum : AppCompatActivity(), MakerAdapter.HomeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.fragment_buatbaru)
    }

}