package com.tottus.ui.team

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tottus.data.OperationResult
import com.tottus.domain.entity.TeamDomain
import com.tottus.domain.usecase.SaveTeamUseCase
import kotlinx.coroutines.launch

class TeamViewModel(private val saveTeamUseCase: SaveTeamUseCase) : ViewModel() {

    private val _isSuccessful = MutableLiveData<Boolean>()
    val isSuccessful: LiveData<Boolean> = _isSuccessful

    private val _showMessage = MutableLiveData<String>()
    val showMessage: LiveData<String> = _showMessage

    fun registerTeam(name: String, sentence: String) {
        viewModelScope.launch {
            val teamDomain = TeamDomain(name, sentence)
            val response = saveTeamUseCase.invoke(teamDomain)
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