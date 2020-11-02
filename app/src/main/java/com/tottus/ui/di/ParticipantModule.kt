package com.tottus.ui.di

import com.tottus.ui.participant.ParticipantAdapter
import com.tottus.ui.participant.ParticipantViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val participantModule = module {
    viewModel { ParticipantViewModel(get(), get()) }
    factory { ParticipantAdapter() }
}