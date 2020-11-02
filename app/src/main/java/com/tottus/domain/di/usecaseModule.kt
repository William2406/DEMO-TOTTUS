package com.tottus.domain.di

import com.tottus.domain.usecase.*
import org.koin.dsl.module

val useCaseModule = module {
    factory { SaveUserUseCase(get()) }
    factory { LoginUseCase(get()) }
    factory { SaveTeamUseCase(get()) }
    factory { GetAllTeamsUseCase(get()) }
    factory { SaveParticipantUseCase(get()) }
    factory { GetTeamWithParticipantUseCase(get()) }
}