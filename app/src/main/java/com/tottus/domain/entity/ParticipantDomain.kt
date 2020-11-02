package com.tottus.domain.entity

import com.tottus.data.database.entity.ParticipantLocal

data class ParticipantDomain(val name: String, val lastName: String) {
    fun toLocal(): ParticipantLocal = ParticipantLocal(
        null,
        name,
        lastName
    )
}