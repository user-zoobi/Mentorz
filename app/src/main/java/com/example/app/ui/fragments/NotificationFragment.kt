package com.example.app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.R
import com.example.app.adapter.NotificationAdapter
import com.example.app.data.model.parser.NotificationModel
import com.example.app.databinding.FragmentHomeBinding
import com.example.app.databinding.FragmentNotificationBinding
import kotlinx.android.synthetic.main.fragment_notification.*

class NotificationFragment : Fragment() {

    lateinit var binding:FragmentNotificationBinding
    private val list = ArrayList<NotificationModel>()
    var adapter = NotificationAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container,false)
        binding.lifecycleOwner = this


        binding.notificationRecyclerview.adapter = adapter
        binding.notificationRecyclerview.layoutManager = LinearLayoutManager(this.context)
        val inputs = NotificationModel("Your request has been accepted")

        for (i in 0..10){
            list.add(inputs)
        }

        return binding.root

    }
}