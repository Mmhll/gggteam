package com.ggg.gggapp.viewmodel.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ggg.gggapp.remote_model.UpdateUserRequest
import com.ggg.gggapp.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class ProfileViewModel @Inject constructor(@Named("userRepository") private val repository: UserRepository) : ViewModel(){
    private val _isDataUpdated : MutableLiveData<Boolean> = MutableLiveData()
    private val isDataUpdated get() = _isDataUpdated

    fun setUserData(token: String, request: UpdateUserRequest) {
        viewModelScope.launch {
            repository.updateUserData(token, request).collect {
                _isDataUpdated.value = it.message != "error"
            }
        }
    }
}