package com.example.cmsmantap

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.cmsmantap.data.LoginActivity

class Notifikasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_notifikasi)

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val btnKeluar = findViewById<ImageButton>(R.id.footer_keluar)

        btnBack.setOnClickListener(){
            onBackPressed()
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