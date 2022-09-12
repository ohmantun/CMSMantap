package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.*
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cmsmantap.data.LoginActivity
import com.example.cmsmantap.data.PayrollUmum


class Beranda_Cheker : AppCompatActivity() {

    lateinit var option: Spinner
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.main_page_cheker)

        val spinner: Spinner = findViewById(R.id.spinner_rek)
        val menubtnPayroll = findViewById<FrameLayout>(R.id.btnOtorisasiPayroll)
        val btnPengaturan = findViewById<ImageButton>(R.id.footer_pengaturan)
        val btnKeluar = findViewById<ImageButton>(R.id.footer_keluar)
        val btnNotifikasi = findViewById<ImageButton>(R.id.btnNotifikasi)
        val btnhide = findViewById<ImageButton>(R.id.btnshowhide)
        val saldo = findViewById<TextView>(R.id.totalSaldo)


        option = findViewById(R.id.spinner_rek) as Spinner
        result = findViewById(R.id.rekeningAsal) as TextView

        var options = arrayOf(
            "PT BALI NUSARAYA PARAMARTHA - 123456789090",
            "PT BALI NUSARAYA PARAMARTHA - 342324254523",
            "PT BALI NUSARAYA PARAMARTHA - 242678432678"
        )

        var norek = arrayOf(
            "TABUNGAN SIMANTAP GOLD \r \n \n123456789090",
            "GIRO \r \n \n342324254523",
            "TABUNGAN SIMANTAP GOLD \r \n \n242678432678"
        )
        option.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options)

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                result.text = "Rekening"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                result.text = norek.get(p2)
            }

        }

// Create an ArrayAdapter using the string array and a default spinner layout
        /*ArrayAdapter.createFromResource(
            this,
            R.array.pilih_rek,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }*/

        menubtnPayroll.setOnClickListener {
            val intent = Intent(this, OtorisasiPayroll::class.java)
            startActivity(intent)
        }

        btnNotifikasi.setOnClickListener {
            val intent = Intent(this, Notifikasi::class.java)
            startActivity(intent)
        }

        btnPengaturan.setOnClickListener {
            val intent = Intent(this, Pengaturan::class.java)
            startActivity(intent)
        }

        var temp = false
        btnhide.setOnClickListener {
            if (!temp) {
                saldo.visibility = View.INVISIBLE
                Toast.makeText(applicationContext, "Invisible", Toast.LENGTH_SHORT).show()
            } else {
                saldo.visibility = View.VISIBLE
                Toast.makeText(applicationContext, "Visible", Toast.LENGTH_SHORT).show()
            }
            temp = !temp

        }
            // when button is clicked, show the alert
        btnKeluar.setOnClickListener {
            val keluarBinding = layoutInflater.inflate(R.layout.keluar_dialog, null)

            val myValidasiDialog = Dialog(this)
            myValidasiDialog.setContentView(keluarBinding)
            myValidasiDialog.setCancelable(true)
            myValidasiDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            myValidasiDialog.show()

            val btnConfirmKeluar = keluarBinding.findViewById<Button>(R.id.btnConfirmKeluar)

            btnConfirmKeluar.setOnClickListener {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

                /*   val confirmBinding = layoutInflater.inflate(R.layout.validasi_sukses_dialog, null)
                   val confirmDialog = Dialog(this)
                   confirmDialog.setContentView(confirmBinding)
                   confirmDialog.setCancelable(true)
                   confirmDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                   confirmDialog.show()

                   val btnOkSelesai = confirmBinding.findViewById<Button>(R.id.btnOkselesai)

                   btnOkSelesai.setOnClickListener {
                       confirmDialog.cancel()
                       myValidasiDialog.cancel()
                   }

                 */
            }

            val btnCancelKeluar = keluarBinding.findViewById<Button>(R.id.btnCancelKeluar)
            btnCancelKeluar.setOnClickListener {
                myValidasiDialog.cancel()
            }

        }



    }
    }
