package com.tottus.domain.usecase

interface BaseUseCase<in Parameter, out Result> {
    suspend operator fun invoke(parameter: Parameter): Result
}