package com.example.cmsmantap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmsmantap.data.MakerModel
import com.example.cmsmantap.ui.ReleaserAdapter
import com.example.cmsmantap.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*


class ReleaserPayrollUmum : AppCompatActivity(), ReleaserAdapter.HomeListener {
    // buat wiring
    private lateinit var vm:HomeViewModel
    private lateinit var adapter: ReleaserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        initAdapter()

        vm.fetchAllTransaksiReleaserUmum()

        vm.ReleaserModelListLiveData?.observe(this, Observer {
            Log.d("data activity releaser",it.toString())
            if (it!=null){
                rv_home.visibility = View.VISIBLE
                adapter.setData(it as ArrayList<MakerModel>)
            }else{
                showToast("Something went wrong")
            }
        })

    }

    private fun initAdapter() {
        adapter = ReleaserAdapter(this)
        rv_home.layoutManager = LinearLayoutManager(this)
        rv_home.adapter = adapter
    }

    private fun showToast(msg:String){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }
}