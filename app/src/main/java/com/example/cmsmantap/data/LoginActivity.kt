package com.example.cmsmantap.data

//import android.app.Activity
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProvider
import android.app.ProgressDialog
import android.os.Bundle
//import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
//import android.text.Editable
//import android.text.TextWatcher
//import android.view.View
//import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import android.widget.EditText
import android.widget.TextView
import com.example.cmsmantap.*

//import com.example.cmsmantap.beranda
//import com.example.cmsmantap.ui.login.LoggedInUserView
//import com.example.cmsmantap.ui.login.LoginViewModel
//import com.example.cmsmantap.ui.login.LoginViewModelFactory

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_login)


        val btnLogin = findViewById<Button>(R.id.login)
        val inputPengguna = findViewById<TextView>(R.id.inputPengguna)
        val inputPassword = findViewById<TextView>(R.id.inputPassword)

        btnLogin.setOnClickListener {

            val pengguna = inputPengguna.text.toString()
            val password = inputPassword.text.toString()
            if (pengguna.isEmpty()|| password.isEmpty()) {
                Toast.makeText(this, "Please Insert ID Institusi, ID Pengguna, and Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(pengguna == "mk001" && password == "adminmk"){
                val intent = Intent (this,Beranda::class.java)
                startActivity(intent)
                finish()
            }
            if(pengguna == "ck001" && password == "adminck"){
                val intent = Intent (this,Beranda_Cheker::class.java)
                startActivity(intent)
                finish()
            }
            if(pengguna == "rl001" && password == "adminrl"){
                val intent = Intent (this,Beranda_Releaser::class.java)
                startActivity(intent)
                finish()
            }

        }

      //      val intent = Intent(this, Beranda::class.java)
      //      startActivity(intent)
        }

    }

  //  val idpengguna = findViewById<TextView>(R.id.inputPengguna)
  //  val password = findViewById<TextView>(R.id.inputPassword)

  //  if (email.isEmpty()|| password.isEmpty()) {
  //      Toast.makeText(this, "Please Insert Email and Password", Toast.LENGTH_SHORT).show()
  //      return@setOnClickListener
 //   }
  //  if(email == "admin01@gmail.com" || password == "admin01"){
  //      val progressDialog = ProgressDialog(this,
  //          R.style.Theme_MaterialComponents_Light_Dialog)
 //       progressDialog.isIndeterminate = true
 //       progressDialog.setMessage("Loading...")
  //      progressDialog.show()





