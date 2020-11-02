package com.tottus.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tottus.domain.entity.ParticipantDomain

@Entity(tableName = "tb_Participant")
data class ParticipantLocal(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "first_name") val firstNames: String?,
    @ColumnInfo(name = "last_name") val lastNames: String?,
    val teamId: Int
) {
    fun toDomain() = ParticipantDomain(
        firstNames ?: "",
        lastNames ?: "",
        teamId
    )
}

fun MutableList<ParticipantLocal>.toDomain() = map(ParticipantLocal::toDomain)