package com.ggg.gggapp.repository

import com.ggg.gggapp.remote_model.AuthenticationRequest
import com.ggg.gggapp.remote_model.AuthenticationResponse
import com.ggg.gggapp.service.AuthenticationService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject
import javax.inject.Named


class AuthRepository @Inject constructor(@Named("authenticationService") val service: AuthenticationService) {
    fun auth(email: String, password: String): Flow<AuthenticationResponse> {
        return flow {
            try {
                val data = service.auth(AuthenticationRequest(email, password))
                emit(data)
            } catch (e: HttpException){
                val data = AuthenticationResponse("", "")
                emit(data)
            }
        }
    }
}