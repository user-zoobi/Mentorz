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
import com.example.app.databinding.ActivitySignUpBinding
import com.example.app.data.viewmodel.MainViewModel
import com.example.dividendatom.data.viewmodel.MainVMFactory
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception


class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var userData:HashMap<String,String>
    lateinit var signupViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        supportActionBar?.hide()
        val repository = MainRepository()
        val factory = MainVMFactory(repository)
        signupViewModel = ViewModelProvider(this,factory).get(MainViewModel::class.java)

        // sending request
        signUpButton.setOnClickListener {

            GlobalScope.launch {
                userSignUp()
            }

            signupViewModel.signupUserRepo.observe(this, Observer { response->
                try {
                    Log.d("Signup Response","The status is ${response.message}")

                    //response success
                    response.status.let {
                        gotoAnotherActivity()
                        Log.d("Signup Response","The status is ${response.message}")
                    }
                }
                catch (e:Exception){
                    Log.d("Exception",e.stackTrace.toString())
                }

            })
        }
    }

    private suspend fun userSignUp() {

        val signupFName = fNameSignUpActivity.text.toString()
        val signupLName = lNameSignUpActivity.text.toString()
        val signupPassword = passwordSignUpActivity.text.toString()
        val signupEmail = emailSignUpActivity.text.toString()
        val signupAddress = addressSignUpActivity.text.toString()
        val signupPhone = phoneSignUpActivity.text.toString()

        // validations
        if (TextUtils.isEmpty(signupFName) || TextUtils.isEmpty(signupLName) || TextUtils.isEmpty(
                signupPassword
            ) || TextUtils.isEmpty(signupEmail)
            || TextUtils.isEmpty(signupAddress) || TextUtils.isEmpty(signupPhone)
        ) {
            Toast.makeText(this, "Empty Field", Toast.LENGTH_SHORT).show()
        }

        //put parameters keys

        userData = HashMap()
        userData.put("fname", signupFName)
        userData.put("lname", signupLName)
        userData.put("gender", "M")
        userData.put("country", "PK")
        userData.put("city", "1")
        userData.put("type", "L")
        userData.put("channel", "App")
        userData.put("phone", signupPhone)
        userData.put("email", signupEmail)
        userData.put("password", signupPassword)
        userData.put("dob", "111111")
        userData.put("address", signupAddress)
        userData.put("action", "signup")
        signupViewModel.signupUsers(userData)

    }

    private fun gotoAnotherActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}