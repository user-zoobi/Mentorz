package com.example.app.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.databinding.MentorSampleBinding
import com.example.app.ui.MentorProfile
import com.example.dividendatom.data.model.parser.GetMemberAction

class ExploreMentorAdapter(val list: ArrayList<GetMemberAction>)
    :RecyclerView.Adapter<ExploreMentorAdapter.ExploreMentorViewHolder>() {

    inner class ExploreMentorViewHolder(var binding: MentorSampleBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreMentorViewHolder {
        val view: MentorSampleBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.mentor_sample, parent, false)
        return ExploreMentorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExploreMentorViewHolder, position: Int) {
        val data = list[position]
        holder.binding.fNameMentor.text = data.fname
        holder.binding.lNameMentor.text = data.lname

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItem(userList: List<GetMemberAction>){
        list.addAll(userList)
        notifyDataSetChanged()
    }
}