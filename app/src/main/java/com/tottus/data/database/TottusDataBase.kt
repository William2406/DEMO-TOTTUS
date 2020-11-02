package com.tottus.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tottus.data.database.dao.ParticipantDao
import com.tottus.data.database.dao.TeamDao
import com.tottus.data.database.dao.UserDao
import com.tottus.data.database.entity.ParticipantLocal
import com.tottus.data.database.entity.TeamLocal
import com.tottus.data.database.entity.UserLocal

@Database(
    entities = arrayOf(UserLocal::class, TeamLocal::class, ParticipantLocal::class),
    version = 2
)
abstract class TottusDataBase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getTeamDao(): TeamDao
    abstract fun getParticipantDao(): ParticipantDao
}