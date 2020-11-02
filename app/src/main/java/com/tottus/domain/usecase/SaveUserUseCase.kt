package com.tottus.domain.usecase

import com.tottus.data.OperationResult
import com.tottus.data.repository.UserRepository
import com.tottus.domain.entity.UserDomain

class SaveUserUseCase(private val repository: UserRepository) :
    BaseUseCase<UserDomain, OperationResult<String>> {

    override suspend fun invoke(parameter: UserDomain): OperationResult<String> {
        return repository.saveLocalUser(user = parameter)
    }
}