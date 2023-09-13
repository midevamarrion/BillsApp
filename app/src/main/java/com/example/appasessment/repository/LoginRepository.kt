package com.example.appasessment.repository

import com.example.appasessment.api.ApiClient
import com.example.appasessment.api.ApiInterface
import com.example.appasessment.models.LoginRequest
import com.example.appasessment.models.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginRepository {
    val apiClient=ApiClient.buildClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest):Response<LoginResponse>{
        return withContext(Dispatchers.IO){
            apiClient.loginUser(loginRequest)
        }
    }
}