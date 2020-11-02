package com.tottus

import android.app.Application
import com.tottus.data.di.dataSourceModule
import com.tottus.data.di.databaseModule
import com.tottus.data.di.repositoryModule
import com.tottus.domain.di.useCaseModule
import com.tottus.ui.di.loginModule
import com.tottus.ui.di.registerModule
import com.tottus.ui.di.teamModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication

class TottusApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TottusApplication)
            modules(dataModules + domainModules + presenterModules)
        }
    }

    private val dataModules = listOf(databaseModule, dataSourceModule, repositoryModule)
    private val domainModules = listOf(useCaseModule)
    private val presenterModules = listOf(registerModule,loginModule,teamModule)
}