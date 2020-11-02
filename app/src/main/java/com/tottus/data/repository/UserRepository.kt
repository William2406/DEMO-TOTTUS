package com.tottus.data.repository

import com.tottus.data.OperationResult
import com.tottus.data.datasource.LocalUserDataSource
import com.tottus.domain.entity.UserDomain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

data class UserRepository(
    private val local: LocalUserDataSource
) {

    suspend fun saveLocalUser(user: UserDomain): OperationResult<String> = local.saveUser(user)

    suspend fun login(email: String, password: String): OperationResult<String> =
        local.verifyLogin(email, password)
}