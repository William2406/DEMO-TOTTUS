package com.tottus.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tottus.domain.entity.UserDomain

@Entity(tableName = "tb_User")
data class UserLocal(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "first_name") val firstNames: String?,
    @ColumnInfo(name = "last_name") val lastNames: String?,
    val email: String,
    val password: String
) {
    fun toDomain(): UserDomain? = UserDomain(
        firstNames ?: "",
        lastNames ?: "",
        email,
        password
    )
}