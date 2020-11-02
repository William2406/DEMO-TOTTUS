package com.tottus.data.database.datasource

import android.util.Log
import com.tottus.data.OperationResult
import com.tottus.data.database.TottusDataBase
import com.tottus.data.datasource.LocalParticipantDataSource
import com.tottus.domain.entity.ParticipantDomain
import java.lang.Exception

class LocalParticipantDataSourceImpl(private val database: TottusDataBase) :
    LocalParticipantDataSource {
    override suspend fun saveParticipant(participant: ParticipantDomain): OperationResult<String> {
        return try {
            val teamLocal = participant.toLocal()
            database.getParticipantDao().saveParticipant(teamLocal)
            OperationResult.Success("Registro Exitoso")

        } catch (e: Exception) {
            Log.e("LocalUserDSI -> ", e.printStackTrace().toString())
            OperationResult.Error("Ocurrio un error")
        }
    }
}