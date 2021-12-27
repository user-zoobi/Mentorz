package com.example.dividendatom.data.model.parser

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetMemberAction {
    @SerializedName("fname")
    @Expose
    val fname: String? = null

    @SerializedName("lname")
    @Expose
    val lname: String? = null

    @SerializedName("email")
    @Expose
    val email: String? = null

    @SerializedName("phone")
    @Expose
    val phone: String? = null

    @SerializedName("city")
    @Expose
    val city: String? = null

    @SerializedName("country")
    @Expose
    val country: String? = null

    @SerializedName("gender")
    @Expose
    val gender: String? = null

    @SerializedName("address")
    @Expose
    val address: String? = null

    @SerializedName("dob")
    @Expose
    val dob: String? = null
}