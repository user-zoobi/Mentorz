package com.example.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.data.model.parser.NotificationModel
import com.example.app.databinding.FragmentNotificationBinding
import com.example.app.databinding.NotificationSampleBinding
import kotlinx.android.synthetic.main.notification_sample.view.*

class NotificationAdapter(val list: ArrayList<NotificationModel>)
    : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    inner class NotificationViewHolder(var binding:NotificationSampleBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view:NotificationSampleBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.notification_sample,parent,false)
        return NotificationViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val data = list[position]
        holder.binding.notificationMessage.text = data.message
    }

    override fun getItemCount(): Int {
       return list.size
    }

}