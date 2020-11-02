package com.tottus.ui.participant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tottus.data.OperationResult
import com.tottus.domain.entity.ParticipantDomain
import com.tottus.domain.usecase.SaveParticipantUseCase
import kotlinx.coroutines.launch

class ParticipantViewModel(private val saveParticipantUseCase: SaveParticipantUseCase) :
    ViewModel() {


    private val _isSuccessful = MutableLiveData<Boolean>()
    val isSuccessful: LiveData<Boolean> = _isSuccessful

    private val _showMessage = MutableLiveData<String>()
    val showMessage: LiveData<String> = _showMessage

    fun registerParticipant(name: String, lastName: String) {
        viewModelScope.launch {
            val participant = ParticipantDomain(name, lastName)
            val response = saveParticipantUseCase.invoke(participant)
            when (response) {
                is OperationResult.Success -> {
                    _isSuccessful.postValue(true)
                    _showMessage.postValue(response.result)
                }
                is OperationResult.Error -> {
                    _isSuccessful.postValue(true)
                    _showMessage.postValue(response.error)
                }
            }
        }
    }
}