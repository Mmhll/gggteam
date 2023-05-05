package com.ggg.gggapp.remote_model

data class UpdatePasswordRequest(
    val id: Int,
    val password: String,
    val username: String
)