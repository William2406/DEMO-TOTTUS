package com.tottus.domain.entity

import com.tottus.data.database.entity.TeamLocal

data class TeamDomain(
    val id: Int?,
    val name: String,
    val sentence: String
) {
    fun toLocal() = TeamLocal(
        null,
        name,
        sentence
    )
}