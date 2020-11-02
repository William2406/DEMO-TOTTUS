package com.tottus.domain.usecase

import com.tottus.data.OperationResult
import com.tottus.data.repository.UserRepository

class LoginUseCase(private val repository: UserRepository) :
    BaseUseCase<Array<out String>, OperationResult<String>> {

    override suspend fun invoke(vararg parameter: String): OperationResult<String> {
        return repository.login(parameter[0], parameter[1])
    }

}