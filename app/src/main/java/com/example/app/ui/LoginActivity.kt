package com.example.app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.app.R
import com.example.app.data.repository.MainRepository
import com.example.app.databinding.ActivityLoginBinding
import com.example.app.data.viewmodel.MainViewModel
import com.example.dividendatom.data.viewmodel.MainVMFactory
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var userData:HashMap<String,String>
    private lateinit var loginViewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        supportActionBar?.hide()
        val repository = MainRepository()
        val factory = MainVMFactory(repository)
        loginViewModel = ViewModelProvider(this,factory).get(MainViewModel::class.java)
        gotoSignup()

        val intent = Intent(this, ExploreMentor::class.java)
        val bundle = Bundle()

        //Observer

        binding.loginButton.setOnClickListener {
            GlobalScope.launch {
                details()
            }
            loginViewModel.loginRequestRepo.observe(this, Observer { response->
                Log.d("Login Response","The response is +${response.status}")
                response.status.let{
                    bundle.putString("name",response.fname)
                    startActivity(intent)
                }
            })
        }

        binding.loginBackButton.setOnClickListener {
            finish()
        }
    }

    private suspend fun details(){

        val emailLogin = emailLoginActivity.text.toString()
        val passwordLogin = passwordLoginActivity.text.toString()

        //validations

        if (TextUtils.isEmpty(emailLogin) || TextUtils.isEmpty(passwordLogin)){
            Toast.makeText(this,"Empty Field",Toast.LENGTH_SHORT).show()
        }

        userData = HashMap()
        userData.put("email",emailLogin)
        userData.put("password",passwordLogin)
        userData.put("action","login")
        loginViewModel.loginUsers(userData)

    }

    private fun gotoSignup(){
        binding.createAccount.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

}