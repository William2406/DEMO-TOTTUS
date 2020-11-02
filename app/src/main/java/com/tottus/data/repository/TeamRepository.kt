package com.tottus.data.repository

import com.tottus.data.OperationResult
import com.tottus.data.datasource.LocalTeamDataSource
import com.tottus.domain.entity.TeamDomain

class TeamRepository(
    private val local: LocalTeamDataSource
) {

    suspend fun saveLocalTeam(team: TeamDomain): OperationResult<String> = local.saveTeam(team)

    suspend fun getAllTeams(): OperationResult<MutableList<TeamDomain>> = local.getAllTeams()
}