package com.example.appasessment.models

import com.google.gson.annotations.SerializedName

data class UserLogin(
    @SerializedName(" first_name") val userName:String,
    val password:String,
    @SerializedName("confirm_password") val confirmPassword:String
)
