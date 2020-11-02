package com.tottus.ui.participant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tottus.data.OperationResult
import com.tottus.domain.entity.ParticipantDomain
import com.tottus.domain.entity.TeamDomain
import com.tottus.domain.usecase.GetTeamWithParticipantUseCase
import com.tottus.domain.usecase.SaveParticipantUseCase
import kotlinx.coroutines.launch

class ParticipantViewModel(
    private val saveParticipantUseCase: SaveParticipantUseCase,
    private val getTeamWithParticipantUseCase: GetTeamWithParticipantUseCase
) : ViewModel() {

    private val _isSuccessful = MutableLiveData<Boolean>()
    val isSuccessful: LiveData<Boolean> = _isSuccessful

    private val _showMessage = MutableLiveData<String>()
    val showMessage: LiveData<String> = _showMessage

    private val _showParticipants = MutableLiveData<MutableList<ParticipantDomain>>()
    val showParticipants: LiveData<MutableList<ParticipantDomain>> = _showParticipants

    fun registerParticipant(name: String, lastName: String, teamId: Int) {
        viewModelScope.launch {
            val participant = ParticipantDomain(name, lastName, teamId)
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

    fun getParticipantWith(id: String) {
        viewModelScope.launch {
            val response = getTeamWithParticipantUseCase.invoke(id.toInt())
            when (response) {
                is OperationResult.Success -> {
                    _isSuccessful.postValue(true)
                    _showParticipants.postValue(response.result)
                }
                is OperationResult.Error -> {
                    _isSuccessful.postValue(false)
                    _showMessage.postValue(response.error)
                }
            }
        }
    }
}