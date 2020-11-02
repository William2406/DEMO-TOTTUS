package com.tottus.data.datasource

import com.tottus.data.OperationResult
import com.tottus.data.database.entity.TeamLocal
import com.tottus.domain.entity.TeamDomain

interface LocalTeamDataSource {
    suspend fun saveTeam(team: TeamDomain): OperationResult<String>
}

interface RemoteTeamDataSource {
}