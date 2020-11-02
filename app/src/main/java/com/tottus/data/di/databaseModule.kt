package com.tottus.data.di

import android.app.Application
import androidx.room.Room
import com.tottus.data.database.TottusDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    fun provideDatabase(application: Application): TottusDataBase {
        return Room.databaseBuilder(application, TottusDataBase::class.java, "tottus")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { provideDatabase(androidApplication()) }
}