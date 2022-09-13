package com.example.cmsmantap.data

//import android.app.Activity
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProvider
import android.app.ProgressDialog
import android.content.Context
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
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cmsmantap.*
import com.example.cmsmantap.viewmodel.HomeViewModel

//import com.example.cmsmantap.beranda
//import com.example.cmsmantap.ui.login.LoggedInUserView
//import com.example.cmsmantap.ui.login.LoginViewModel
//import com.example.cmsmantap.ui.login.LoginViewModelFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var vm: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_CMSMantap)
        setContentView(R.layout.activity_login)

        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        val btnLogin = findViewById<Button>(R.id.login)
        val inputInstitusi = findViewById<TextView>(R.id.inputInstitusi)
        val inputPengguna = findViewById<TextView>(R.id.inputPengguna)
        val inputPassword = findViewById<TextView>(R.id.inputPassword)

        btnLogin.setOnClickListener {
            val institusi = inputInstitusi.text.toString()
            val pengguna = inputPengguna.text.toString()
            val password = inputPassword.text.toString()

            val loginModel = LoginModel()
            loginModel.institusi_id = institusi
            loginModel.username = pengguna
            loginModel.password = password

            // Log.wtf("DEBUG loginModel", loginModel.toString())
            // Log.wtf("DEBUG institusi", institusi)

            if (institusi.isEmpty()) {
                Toast.makeText(this, "Silahkan masukkan ID Institusi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (pengguna.isEmpty()) {
                Toast.makeText(this, "Silahkan masukkan ID Pengguna", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (password.isEmpty()) {
                Toast.makeText(this, "Silahkan masukkan Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {

                vm.login(loginModel)
                Log.d("institusi id", institusi)
                vm.loginLiveData?.observe(this, Observer {
                    if (it!=null){
                        Log.d("DEBUG login success", it.toString())
                        // val role_id = it.data.user.role_id
                        if(it.data?.user?.role_id === 1) {
                            val intent = Intent(this, Beranda::class.java)
                            startActivity(intent)
                            finish()
                        } else if(it.data?.user?.role_id === 2){
                            val intent = Intent (this,Beranda_Cheker::class.java)
                            startActivity(intent)
                            finish()
                        } else if(it.data?.user?.role_id === 3){
                            val intent = Intent (this,Beranda_Releaser::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "ID Institusi / ID Pengguna / Password Salah", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Log.d("DEBUG login failure", "it.password.toString()")
                        Toast.makeText(this, "ID Institusi / ID Pengguna / Password Salah", Toast.LENGTH_SHORT).show()
                    }
                    //dialog.cancel()
                })
                Log.d("pengguna id", pengguna)
            }

//            if(pengguna == "maker001" && password == "odpit"){
//                val intent = Intent (this,Beranda::class.java)
//                startActivity(intent)
//                finish()
//            }
//            else if(pengguna == "checker001" && password == "odpit"){
//                val intent = Intent (this,Beranda_Cheker::class.java)
//                startActivity(intent)
//                finish()
//            }
//            else if(pengguna == "releaser001" && password == "odpit"){
//                val intent = Intent (this,Beranda_Releaser::class.java)
//                startActivity(intent)
//                finish()
//            }else{
//                Toast.makeText(this, "ID Institusi / ID Pengguna / Password Salah", Toast.LENGTH_SHORT).show()
//            }
            /* API fetch sinergimantap.users
            if(institusi_id == api_fetch && username == api_fetch && password == api_fetch){
                if("select role_id from users where username == api_fetch" == 1){
                    directed to MAKER page
                }
                elif("select role_id from users where username == api_fetch" == 1){
                    directed to CHECKER page
                }
                elif("select role_id from users where username == api_fetch" == 1){
                    directed to RELEASER page
                }
                elif("select role_id from users where username == api_fetch" == 1){
                    directed to ADMIN page
                }
            } */

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





