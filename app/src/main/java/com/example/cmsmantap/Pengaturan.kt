package com.example.cmsmantap

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.cmsmantap.data.LoginActivity

class Pengaturan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_pengaturan)

      //  val btnPayrollUmum = findViewById<ImageButton>(R.id.btnPayroll_umum)
      //  val btnPayrollPensiunan = findViewById<ImageButton>(R.id.btnPayroll_pensiunan)
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val btnGantiSandi = findViewById<CardView>(R.id.btnGantiSandi)
        val btnBeranda = findViewById<ImageButton>(R.id.footer_beranda)
        val btnKeluar = findViewById<ImageButton>(R.id.footer_keluar)


        btnBack.setOnClickListener(){
            onBackPressed()
        }

        btnBeranda.setOnClickListener{
            val intent = Intent(this, Beranda::class.java)
            startActivity(intent)
        }

        btnGantiSandi.setOnClickListener{
            val intent = Intent(this, GantiSandi::class.java) //Login Activity ganti ke page sandinya
            startActivity(intent)
        }

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