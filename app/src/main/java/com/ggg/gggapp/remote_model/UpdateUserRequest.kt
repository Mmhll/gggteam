package com.ggg.gggapp.remote_model

data class UpdateUserRequest(
    val email: String,
    val firstname: String,
    val id: Long,
    val lastname: String,
    val middlename: String,
    val username: String
)