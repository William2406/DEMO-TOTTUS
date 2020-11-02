package com.tottus.domain.usecase

import com.tottus.data.OperationResult
import com.tottus.data.repository.TeamRepository
import com.tottus.domain.entity.TeamDomain

class GetAllTeamsUseCase(private val repository: TeamRepository) :
    BaseUseCase<Unit, OperationResult<MutableList<TeamDomain>>> {
    override suspend fun invoke(parameter: Unit): OperationResult<MutableList<TeamDomain>> {
        return repository.getAllTeams()
    }
}