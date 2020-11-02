package com.tottus.ui.di

import com.tottus.ui.team.TeamViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val teamModule = module {
    viewModel { TeamViewModel(get()) }
}