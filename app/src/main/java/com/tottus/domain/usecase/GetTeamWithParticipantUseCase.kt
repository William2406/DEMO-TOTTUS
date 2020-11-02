package com.tottus.domain.usecase

import com.tottus.data.OperationResult
import com.tottus.data.repository.ParticipantRepository
import com.tottus.domain.entity.ParticipantDomain

class GetTeamWithParticipantUseCase(private val repository: ParticipantRepository) :
    BaseUseCase<Int, OperationResult<MutableList<ParticipantDomain>>> {


    override suspend fun invoke(parameter: Int): OperationResult<MutableList<ParticipantDomain>> {
        return repository.getTeamWithParticipant(parameter)
    }
}