package com.tottus.data.datasource

import com.tottus.data.OperationResult
import com.tottus.domain.entity.UserDomain

interface LocalUserDataSource {
    suspend fun saveUser(user: UserDomain): OperationResult<String>
}

interface RemoteUserDataSource {

}