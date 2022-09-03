package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.app.AlertDialog
import android.content.DialogInterface
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


class Beranda : AppCompatActivity() {

    lateinit var option: Spinner
    lateinit var result: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_main_page)

        //  val spinner: Spinner = findViewById(R.id.spinner_rek)
        val menubtnPayroll = findViewById<FrameLayout>(R.id.btnPayroll)
        val btnPengaturan = findViewById<ImageButton>(R.id.footer_pengaturan)
        val btnKeluar = findViewById<ImageButton>(R.id.footer_keluar)
        val btnPending = findViewById<FrameLayout>(R.id.info_pending)
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
        //   ArrayAdapter.createFromResource(
        //       this,
        //       R.array.pilih_rek,
        //       android.R.layout.simple_spinner_item
        //   ).also { adapter ->
        // Specify the layout to use when the list of choices appears
        //       adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        // Apply the adapter to the spinner
        //       spinner.adapter = adapter
        //   }

        menubtnPayroll.setOnClickListener {
            val intent = Intent(this, Payroll::class.java)
            startActivity(intent)
        }

        btnPengaturan.setOnClickListener {
            val intent = Intent(this, Pengaturan::class.java)
            startActivity(intent)
        }

        btnNotifikasi.setOnClickListener {
            val intent = Intent(this, Notifikasi::class.java)
            startActivity(intent)
        }

        btnPending.setOnClickListener {
            val intent = Intent(this, Pengaturan::class.java)
            startActivity(intent)
        }

        btnhide.setOnClickListener {
            if (btnhide.isClickable.toString().equals("Show")) {
                saldo.transformationMethod = HideReturnsTransformationMethod.getInstance()
                btnhide.isClickable
           } else {
                saldo.transformationMethod = PasswordTransformationMethod.getInstance()
               btnhide.isClickable
            }

            // when button is clicked, show the alert
            btnKeluar.setOnClickListener {
                // build alert dialog
                val dialogBuilder = AlertDialog.Builder(this)

                // set message of alert dialog
                dialogBuilder.setMessage("Apakah anda yakin ingin keluar?")
                    // if the dialog is cancelable
                    .setCancelable(false)
                    // positive button text and action
                    .setPositiveButton("Keluar", DialogInterface.OnClickListener { dialog, id ->
                        finish()
                    })
                    // negative button text and action
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                        dialog.cancel()
                    })

                // create dialog box
                val alert = dialogBuilder.create()
                // set title for alert dialog box
                alert.setTitle("Keluar")
                // show alert dialog
                alert.show()
            }


        }
    }
}