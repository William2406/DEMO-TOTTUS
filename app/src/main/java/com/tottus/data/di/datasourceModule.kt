package com.tottus.data.di

import com.tottus.data.database.datasource.LocalTeamDataSourceImpl
import com.tottus.data.database.datasource.LocalUserDataSourceImpl
import com.tottus.data.datasource.LocalTeamDataSource
import com.tottus.data.datasource.LocalUserDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<LocalUserDataSource> { LocalUserDataSourceImpl(get()) }
    single<LocalTeamDataSource> { LocalTeamDataSourceImpl(get()) }
}