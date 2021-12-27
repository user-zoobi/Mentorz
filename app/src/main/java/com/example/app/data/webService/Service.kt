package com.example.dividendatom.data.webService

import com.example.app.data.model.parser.GetBannerList
import com.example.dividendatom.data.model.parser.GetMemberAction
import com.example.dividendatom.data.model.parser.LoginAction
import com.example.dividendatom.data.model.parser.SignupAction
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Service {

    @FormUrlEncoded
    @POST(URL.ENDPOINT)
    suspend fun loginUsers(
        @FieldMap map: Map<String,String>
    ): LoginAction

    @FormUrlEncoded
    @POST(URL.ENDPOINT)
    suspend fun signupUsers(
        @FieldMap map: Map<String,String>
    ):SignupAction

    @FormUrlEncoded
    @POST(URL.ENDPOINT)
    suspend fun getMembersList(
        @FieldMap map: Map<String,String>
    ):List<GetMemberAction>

    @FormUrlEncoded
    @POST(URL.ENDPOINT)
    suspend fun getBannersList(
        @FieldMap map: Map<String,String>
    ):List<GetBannerList>

}