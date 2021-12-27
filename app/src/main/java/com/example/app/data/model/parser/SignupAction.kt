package com.example.dividendatom.data.model.parser

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SignupAction {

    @SerializedName("status")
    @Expose
    val status: Boolean? = null

    @SerializedName("message")
    @Expose
    val message: String? = null

}