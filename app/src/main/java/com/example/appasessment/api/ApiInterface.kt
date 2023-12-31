package com.example.appasessment.api

import com.example.appasessment.models.LoginRequest
import com.example.appasessment.models.LoginResponse
import com.example.appasessment.models.RegisterRequest
import com.example.appasessment.models.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/users/register")
   suspend fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>
   @POST("/users/login")
   suspend fun loginUser(@Body loginRequest: LoginRequest):Response<LoginResponse>
}