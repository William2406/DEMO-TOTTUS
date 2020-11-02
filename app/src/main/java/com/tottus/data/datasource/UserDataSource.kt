package com.tottus.data.datasource

import com.tottus.data.OperationResult
import com.tottus.domain.entity.UserDomain

interface LocalUserDataSource {
    suspend fun saveUser(user: UserDomain): OperationResult<String>
    suspend fun verifyLogin(email: String, password: String): OperationResult<String>
}

interface RemoteUserDataSource {

}