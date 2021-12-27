package com.example.app.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageAdapter {

    @BindingAdapter("imageFromUrl")
    @JvmStatic
    fun imageFromUrl(imageView: ImageView,imageUrl:String){
        if (imageUrl.isNullOrEmpty()){
            Glide.with(imageView.context).load(imageUrl).into(imageView)
        }
    }
}