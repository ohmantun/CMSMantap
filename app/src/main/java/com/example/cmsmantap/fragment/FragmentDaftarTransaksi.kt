package com.example.cmsmantap.fragment

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.cmsmantap.R
import com.example.cmsmantap.databinding.FragmentDaftartransaksiBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class FragmentDaftarTransaksi : Fragment() {

    private var _binding: FragmentDaftartransaksiBinding? = null
    private val binding get() = _binding!!
    //private lateinit var fragmentAdapter : FragmentAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDaftartransaksiBinding.inflate(inflater, container, false)
        return binding.root
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentAdapter = FragmentAdapter(this)

        with(binding){
            viewPager.adapter = fragmentAdapter

            TabLayoutMediator(tabLayout,viewPager){tab, position ->
                when(position){
                    0 -> tab.text = "Buat Baru"
                    1 -> tab.text = "Daftar Transaksi"
                }
            }.attach()
        }
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}