package com.tottus.domain.usecase

import com.tottus.data.OperationResult
import com.tottus.data.repository.ParticipantRepository
import com.tottus.domain.entity.ParticipantDomain

class SaveParticipantUseCase(private val repository: ParticipantRepository) :
    BaseUseCase<ParticipantDomain, OperationResult<String>> {
    override suspend fun invoke(parameter: ParticipantDomain): OperationResult<String> {
        return repository.saveParticipant(parameter)
    }
}