package com.tottus.domain.usecase

import com.tottus.data.OperationResult
import com.tottus.data.repository.UserRepository
import com.tottus.domain.entity.UserDomain

class LoginUseCase(private val repository: UserRepository) :
    BaseUseCase<Array<out String>, OperationResult<UserDomain>> {

    override suspend fun invoke(vararg parameter: String): OperationResult<UserDomain> {
        return repository.login(parameter[0], parameter[1])
    }

}