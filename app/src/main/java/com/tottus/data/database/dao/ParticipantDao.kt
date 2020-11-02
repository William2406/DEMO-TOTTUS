package com.tottus.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.tottus.data.database.entity.ParticipantLocal

@Dao
interface ParticipantDao {

    @Insert
    suspend fun saveParticipant(participantLocal: ParticipantLocal)
}