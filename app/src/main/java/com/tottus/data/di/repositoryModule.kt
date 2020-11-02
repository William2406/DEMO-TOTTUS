package com.tottus.data.di

import com.tottus.data.repository.ParticipantRepository
import com.tottus.data.repository.TeamRepository
import com.tottus.data.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { UserRepository(get()) }
    factory { TeamRepository(get()) }
    factory { ParticipantRepository(get()) }
}