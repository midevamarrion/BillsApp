package com.example.appasessment.repository

import com.example.appasessment.api.ApiClient
import com.example.appasessment.api.ApiInterface
import com.example.appasessment.models.RegisterRequest
import com.example.appasessment.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var apiClient=ApiClient.buildClient(ApiInterface::class.java)
    suspend fun registerUser(registerRequest: RegisterRequest): Response<RegisterResponse> {
        return  withContext(Dispatchers.IO){
            apiClient.registerUser(registerRequest)
        }
    }
}
