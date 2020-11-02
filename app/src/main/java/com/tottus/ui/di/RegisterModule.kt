package com.tottus.ui.di

import com.tottus.ui.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val registerModule = module {
    viewModel { RegisterViewModel(get()) }
}