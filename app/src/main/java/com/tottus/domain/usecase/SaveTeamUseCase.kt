package com.tottus.domain.usecase

import com.tottus.data.OperationResult
import com.tottus.data.repository.TeamRepository
import com.tottus.domain.entity.TeamDomain

class SaveTeamUseCase(private val repository: TeamRepository) :
    BaseUseCase<TeamDomain, OperationResult<String>> {
    override suspend fun invoke(parameter: TeamDomain): OperationResult<String> {
        return repository.saveLocalTeam(parameter)
    }
}