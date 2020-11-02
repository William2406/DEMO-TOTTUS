package com.tottus.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.tottus.data.database.entity.TeamLocal

@Dao
interface TeamDao {

    @Insert
    suspend fun saveTeam(team: TeamLocal)


}