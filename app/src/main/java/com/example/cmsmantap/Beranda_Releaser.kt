package com.example.cmsmantap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import android.app.AlertDialog
import android.content.DialogInterface
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


class Beranda_Releaser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.main_page_releaser)

        val spinner: Spinner = findViewById(R.id.spinner_rek)
        val menubtnPayroll = findViewById<ImageButton>(R.id.btnOtoritasPayrollReleaser)
        val btnPengaturan = findViewById<ImageButton>(R.id.footer_pengaturan)
        val btnKeluar = findViewById<ImageButton>(R.id.footer_keluar)

// Create an ArrayAdapter using the string array and a default spinner layout
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

        menubtnPayroll.setOnClickListener {
            val intent = Intent(this, ApprovelPayroll::class.java)
            startActivity(intent)
        }

        btnPengaturan.setOnClickListener {
            val intent = Intent(this, Pengaturan::class.java)
            startActivity(intent)
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
                .setPositiveButton("Keluar", DialogInterface.OnClickListener {
                        dialog, id -> finish()
                })
                // negative button text and action
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
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