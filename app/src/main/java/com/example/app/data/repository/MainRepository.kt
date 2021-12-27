package com.example.app.data.repository

import com.example.dividendatom.data.webService.RetrofitClient.Companion.service

class MainRepository() {

     suspend fun loginUsers(map: Map<String,String>) = service.loginUsers(map)
     suspend fun signupUsers(map: Map<String, String>) = service.signupUsers(map)
     suspend fun getMemberList(map: Map<String, String>) = service.getMembersList(map)
     suspend fun getBannerList(map: Map<String, String>) = service.getBannersList(map)

}