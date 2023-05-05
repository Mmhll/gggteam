package com.ggg.gggapp.viewmodel.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ggg.gggapp.remote_model.AuthenticationResponse
import com.ggg.gggapp.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class AuthViewModel @Inject constructor(
    @Named("authenticationRepository") private val authRepository: AuthRepository
) : ViewModel() {
    private val _data: MutableLiveData<AuthenticationResponse> = MutableLiveData()
    val data get() = _data

    fun authorize(email: String, password: String) {
        viewModelScope.launch {
            authRepository.auth(email, password).collect{
                _data.value = it
            }
        }
    }
}