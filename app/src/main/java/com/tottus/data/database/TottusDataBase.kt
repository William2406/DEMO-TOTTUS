package com.tottus.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tottus.data.database.dao.UserDao
import com.tottus.data.database.entity.UserLocal

@Database(entities = arrayOf(UserLocal::class), version = 2)
abstract class TottusDataBase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}