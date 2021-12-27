package com.example.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.app.R
import com.example.app.databinding.ActivityMentorProfileBinding
import com.example.app.databinding.ActivitySignUpBinding

class MentorProfile : AppCompatActivity() {
    private lateinit var binding: ActivityMentorProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mentor_profile)

    }
}