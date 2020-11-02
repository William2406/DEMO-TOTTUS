package com.tottus.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tottus.data.database.entity.UserLocal

@Dao
interface UserDao {
    @Insert
    suspend fun saveUser(user: UserLocal)

    @Query("SELECT * FROM tb_User where email = :email ")
    suspend fun userVerify(email: String): UserLocal?

    @Query("SELECT * FROM tb_User where email = :email AND password = :password")
    suspend fun verifyLogin(email: String, password: String): UserLocal?
}