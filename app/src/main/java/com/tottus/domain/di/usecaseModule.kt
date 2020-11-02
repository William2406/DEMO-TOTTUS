package com.tottus.domain.di

import com.tottus.domain.usecase.SaveUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { SaveUserUseCase(get()) }
}