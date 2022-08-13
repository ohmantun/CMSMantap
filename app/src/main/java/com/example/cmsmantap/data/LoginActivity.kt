package com.example.cmsmantap.data

//import android.app.Activity
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
//import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
//import android.text.Editable
//import android.text.TextWatcher
//import android.view.View
//import android.view.inputmethod.EditorInfo
import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import com.example.cmsmantap.databinding.ActivityLoginBinding
import android.content.Intent
import com.example.cmsmantap.R
import com.example.cmsmantap.Beranda
//import com.example.cmsmantap.beranda
//import com.example.cmsmantap.ui.login.LoggedInUserView
//import com.example.cmsmantap.ui.login.LoginViewModel
//import com.example.cmsmantap.ui.login.LoginViewModelFactory

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_login)

        val secondActbutton = findViewById<Button>(R.id.login)
        secondActbutton.setOnClickListener {
            val intent = Intent(this,Beranda::class.java)
            startActivity(intent)

        }

    }    }
