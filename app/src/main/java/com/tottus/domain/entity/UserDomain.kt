package com.tottus.domain.entity

import com.tottus.data.database.entity.UserLocal
import java.io.Serializable

data class UserDomain(
    val names: String,
    val lastNames: String,
    val email: String,
    val password: String
) : Serializable {
    fun toLocal(): UserLocal = UserLocal(
        id = null,
        firstNames = names,
        lastNames = lastNames,
        email = email,
        password = password
    )
}