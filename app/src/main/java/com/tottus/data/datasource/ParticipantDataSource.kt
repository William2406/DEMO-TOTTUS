package com.tottus.data.datasource

import com.tottus.data.OperationResult
import com.tottus.domain.entity.ParticipantDomain

interface LocalParticipantDataSource {
    suspend fun saveParticipant(participant: ParticipantDomain): OperationResult<String>
}

interface RemoteParticipantDataSource {}