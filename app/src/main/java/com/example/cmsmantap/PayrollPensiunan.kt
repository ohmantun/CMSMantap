package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.cmsmantap.databinding.ActivityPayrollPensiunanBinding
import com.example.cmsmantap.fragment.FragmentPensiunan
import com.google.android.material.tabs.TabLayoutMediator

class PayrollPensiunan : AppCompatActivity() {
    private lateinit var binding: ActivityPayrollPensiunanBinding
    private lateinit var fragmentAdapter : FragmentPensiunan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_payroll_pensiunan)
        binding = ActivityPayrollPensiunanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentAdapter = FragmentPensiunan(supportFragmentManager,lifecycle)

        with(binding){
            viewPager.adapter = fragmentAdapter

            TabLayoutMediator(tabLayout,viewPager){tab, position ->
                when(position){
                    0 -> tab.text = "Buat Baru"
                    1 -> tab.text = "Daftar Transaksi"
                }
            }.attach()
        }

       // val rgTglPembayaran = findViewById<RadioGroup>(R.id.rgtglpembayaran)
      //  val btnCancel = findViewById<Button>(R.id.btnCancel)
      //  val btnProcess = findViewById<Button>(R.id.btnProses)
        val btnBack = findViewById<ImageView>(R.id.btnBack)

        btnBack.setOnClickListener {
            val intent = Intent(this,Payroll::class.java)
            startActivity(intent)
        }

      /*  btnProcess.setOnClickListener{

            val cekTglPembayaranRadioButton = rgTglPembayaran.checkedRadioButtonId
            val tglPembayaran = findViewById<RadioButton>(cekTglPembayaranRadioButton)

            if (rgTglPembayaran == null){
                Toast.makeText(this@PayrollPensiunan,
                    "Harap pilih salah satu tanggal pembayaran gaji",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(this@PayrollPensiunan,
                    "Proses Berhasil!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


        val spinner: Spinner = findViewById(R.id.spinner_rek_sumber)

        ArrayAdapter.createFromResource(
            this,
            R.array.pilih_rek,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

*/

    }
}