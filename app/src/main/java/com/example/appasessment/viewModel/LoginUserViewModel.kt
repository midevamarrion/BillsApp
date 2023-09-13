package com.example.appasessment.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appasessment.models.LoginRequest
import com.example.appasessment.models.LoginResponse
import com.example.appasessment.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginUserViewModel:ViewModel() {
    val loginLiveData = MutableLiveData<LoginResponse>()
    val errorLiveData = MutableLiveData<String>()
    val loginRepository = LoginRepository()
    fun loginUser(loginRequest: LoginRequest) {
        viewModelScope.launch {
            val response = loginRepository.loginUser(loginRequest)
            loginLiveData.postValue(response.body())
            if (response.isSuccessful) {
                loginLiveData.postValue(response.body())
            } else {
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}