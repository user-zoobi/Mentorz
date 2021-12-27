package com.example.app.data.model.parser

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetBannerList {
   @SerializedName("img")
   @Expose()
   val image :String? = null
}