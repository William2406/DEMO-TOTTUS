package com.tottus.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tottus.domain.entity.TeamDomain

@Entity(tableName = "tb_Team")
data class TeamLocal(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val name: String?,
    val sentence: String
) {
    fun toDomain() = TeamDomain(
        id ?: 1,
        name ?: "",
        sentence
    )
}

fun MutableList<TeamLocal>.toDomain() = map(TeamLocal::toDomain)