package com.tottus.data.repository

import com.tottus.data.OperationResult
import com.tottus.data.datasource.LocalParticipantDataSource
import com.tottus.domain.entity.ParticipantDomain

class ParticipantRepository(
    private val local: LocalParticipantDataSource
) {
    suspend fun saveParticipant(participant: ParticipantDomain) = local.saveParticipant(participant)

    suspend fun getTeamWithParticipant(id: Int): OperationResult<MutableList<ParticipantDomain>> =
        local.getParticipants(id)
}