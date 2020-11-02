package com.tottus.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.tottus.data.database.entity.UserLocal

@Dao
interface UserDao {
    @Insert
    suspend fun saveUser(user: UserLocal)
}