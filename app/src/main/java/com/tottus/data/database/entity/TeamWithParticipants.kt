package com.tottus.data.database.entity

import androidx.room.Embedded
import androidx.room.Relation

class TeamWithParticipants(
    @Embedded val team: TeamLocal,
    @Relation(
        parentColumn = "id",
        entityColumn = "teamId"
    )
    val participants: MutableList<ParticipantLocal>
)