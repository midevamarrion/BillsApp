package com.example.appasessment.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appasessment.models.RegisterRequest
import com.example.appasessment.models.RegisterResponse
import com.example.appasessment.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val registerLiveData=MutableLiveData<RegisterResponse>()
    val errorLiveData=MutableLiveData<String>()
    val userRepository=UserRepository()
    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response=userRepository.registerUser(registerRequest)
            registerLiveData.postValue(response.body())
            if (response.isSuccessful){
                registerLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}