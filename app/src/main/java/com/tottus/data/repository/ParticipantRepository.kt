package com.tottus.data.repository

import com.tottus.data.datasource.LocalParticipantDataSource
import com.tottus.domain.entity.ParticipantDomain

class ParticipantRepository(
    private val local: LocalParticipantDataSource
) {
    suspend fun saveParticipant(participant: ParticipantDomain) = local.saveParticipant(participant)
}