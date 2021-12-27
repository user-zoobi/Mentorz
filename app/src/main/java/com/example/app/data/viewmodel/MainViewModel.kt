package com.example.app.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.data.model.parser.GetBannerList
import com.example.dividendatom.data.model.parser.GetMemberAction
import com.example.dividendatom.data.model.parser.LoginAction
import com.example.dividendatom.data.model.parser.SignupAction
import com.example.app.data.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(val repository: MainRepository):ViewModel() {

    val loginRequestRepo :MutableLiveData<LoginAction> = MutableLiveData()
    val signupUserRepo : MutableLiveData<SignupAction> = MutableLiveData()
    val memberListRepo : MutableLiveData<List<GetMemberAction>> = MutableLiveData()
    val bannerListRepo : MutableLiveData<List<GetBannerList>> = MutableLiveData()


     suspend fun loginUsers(map: Map<String,String>){
         viewModelScope.launch {
             val userResponse = repository.loginUsers(map)
             loginRequestRepo.value = userResponse
         }
     }

    suspend fun signupUsers(map: Map<String, String>) {
        viewModelScope.launch {
            val userSignup = repository.signupUsers(map)
            signupUserRepo.value = userSignup
        }
    }

    suspend fun getMembers(map: Map<String, String>){
        viewModelScope.launch {
            val members = repository.getMemberList(map)
            memberListRepo.value = members
        }
    }

    suspend fun getBanners(map: Map<String, String>){
        viewModelScope.launch {
            val banners = repository.getBannerList(map)
            bannerListRepo.value = banners
        }
    }
}