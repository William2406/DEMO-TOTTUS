package com.tottus.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.tottus.data.database.entity.ParticipantLocal
import com.tottus.data.database.entity.TeamWithParticipants

@Dao
interface ParticipantDao {

    @Insert
    suspend fun saveParticipant(participantLocal: ParticipantLocal)

    @Transaction
    @Query("SELECT * FROM tb_Team where id=:id")
    suspend fun getTeamWithParticipants(id: Int): MutableList<TeamWithParticipants>
}