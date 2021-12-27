package com.example.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.app.R
import com.example.app.data.viewmodel.MainViewModel
import com.example.app.databinding.ActivityExploreMentorBinding
import com.example.app.adapter.ExploreMentorAdapter
import com.example.app.data.model.parser.GetBannerList
import com.example.app.data.repository.MainRepository
import com.example.dividendatom.data.model.parser.GetMemberAction
import com.example.dividendatom.data.viewmodel.MainVMFactory
import kotlinx.android.synthetic.main.activity_explore_mentor.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ExploreMentor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore_mentor)
        supportActionBar?.hide()

        val navController = findNavController(R.id.hostFragment)
        bottomNavigationMenu.setupWithNavController(navController)

    }
}
