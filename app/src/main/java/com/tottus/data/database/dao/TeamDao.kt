package com.tottus.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tottus.data.database.entity.TeamLocal

@Dao
interface TeamDao {

    @Insert
    suspend fun saveTeam(team: TeamLocal)

    @Query("SELECT * FROM tb_Team")
    suspend fun getAllTeams(): MutableList<TeamLocal>
}