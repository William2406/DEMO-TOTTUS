package com.tottus.domain.di

import com.tottus.domain.usecase.LoginUseCase
import com.tottus.domain.usecase.SaveTeamUseCase
import com.tottus.domain.usecase.SaveUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { SaveUserUseCase(get()) }
    factory { LoginUseCase(get()) }
    factory { SaveTeamUseCase(get()) }
}