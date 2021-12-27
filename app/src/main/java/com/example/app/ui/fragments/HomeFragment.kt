package com.example.app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.R
import com.example.app.adapter.ExploreMentorAdapter
import com.example.app.data.repository.MainRepository
import com.example.app.data.viewmodel.MainViewModel
import com.example.app.databinding.FragmentHomeBinding
import com.example.app.ui.LoginActivity
import com.example.dividendatom.data.model.parser.GetMemberAction
import com.example.dividendatom.data.viewmodel.MainVMFactory
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    lateinit var homeViewModel:MainViewModel
    private var list = ArrayList<GetMemberAction>()
    private var homeAdapter = ExploreMentorAdapter(list)
    lateinit var userData: HashMap<String,String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val repository = MainRepository()
        val factory = MainVMFactory(repository)
        homeViewModel = ViewModelProvider(this,factory)[MainViewModel::class.java]
        val binding:FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container,false)

        GlobalScope.launch {
            homeObserver()
        }

        homeViewModel.memberListRepo.observe(viewLifecycleOwner, Observer { response->

            list = response as ArrayList<GetMemberAction>
            mentorList.adapter = homeAdapter
            mentorList.layoutManager = LinearLayoutManager(this.context)
            homeAdapter.addItem(list)

        })

        binding.lifecycleOwner = this
        return binding.root

    }

    private suspend fun homeObserver(){

        userData = HashMap()
        userData.put("action","getmemberlist")
        homeViewModel.getMembers(userData)

    }
}