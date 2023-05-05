package com.ggg.gggapp.service

import com.ggg.gggapp.remote_model.AuthenticationRequest
import com.ggg.gggapp.remote_model.AuthenticationResponse
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthenticationService {
    @POST("auth/signin")
    suspend fun auth(@Body request: AuthenticationRequest): AuthenticationResponse
}