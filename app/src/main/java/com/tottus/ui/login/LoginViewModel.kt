package com.tottus.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tottus.data.OperationResult
import com.tottus.domain.usecase.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _isSuccessful = MutableLiveData<Boolean>()
    val isSuccessful: LiveData<Boolean> = _isSuccessful

    private val _showResult = MutableLiveData<Any>()
    val showResult: LiveData<Any> = _showResult

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val response = loginUseCase.invoke(email, password)
            when (response) {
                is OperationResult.Success -> {
                    _isSuccessful.postValue(true)
                    _showResult.postValue(response.result)
                }
                is OperationResult.Error -> {
                    _isSuccessful.postValue(false)
                    _showResult.postValue(response.error)
                }
            }
        }
    }
}