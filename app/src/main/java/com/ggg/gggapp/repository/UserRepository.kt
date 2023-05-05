package com.ggg.gggapp.repository

import com.ggg.gggapp.remote_model.MessageResponse
import com.ggg.gggapp.remote_model.UpdatePasswordRequest
import com.ggg.gggapp.remote_model.UpdateUserRequest
import com.ggg.gggapp.service.UserService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class UserRepository @Inject constructor(private val userService: UserService) {

    fun updateUserData(token: String, request: UpdateUserRequest): Flow<MessageResponse>{
        return flow {
            try {
                emit(userService.updateUserData("Bearer $token", request))
            } catch (_: HttpException){
                emit(MessageResponse("Error"))
            }
        }
    }

    fun updateUserPassword(token: String, request: UpdatePasswordRequest): Flow<MessageResponse>{
        return flow {
            try {
                emit(userService.updateUserPassword("Bearer $token", request))
            } catch (_: HttpException){
                emit(MessageResponse("Error"))
            }
        }
    }

}