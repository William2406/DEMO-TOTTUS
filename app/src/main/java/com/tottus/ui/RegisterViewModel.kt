package com.tottus.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tottus.data.OperationResult
import com.tottus.domain.entity.UserDomain
import com.tottus.domain.usecase.SaveUserUseCase
import kotlinx.coroutines.launch

class RegisterViewModel(private val saveUserUseCase: SaveUserUseCase) : ViewModel() {

    private val _isSuccessful = MutableLiveData<Boolean>()
    val isSuccessful: LiveData<Boolean> = _isSuccessful

    private val _showMessage = MutableLiveData<String>()
    val showMessage: LiveData<String> = _showMessage

    fun registerUser(names: String, lastNames: String, email: String, password: String) {
        viewModelScope.launch {
            val user = UserDomain(names, lastNames, email, password)
            val response = saveUserUseCase.invoke(user)
            when (response) {
                is OperationResult.Success -> {
                    _isSuccessful.postValue(true)
                    _showMessage.postValue(response.result)
                }
                is OperationResult.Error -> {
                    _isSuccessful.postValue(false)
                    _showMessage.postValue(response.error)
                }
            }
        }

    }
}