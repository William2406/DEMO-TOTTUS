package com.tottus.data.di

import com.tottus.data.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { UserRepository(get()) }
}