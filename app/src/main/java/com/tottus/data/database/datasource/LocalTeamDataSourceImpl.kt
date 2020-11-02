package com.tottus.data.database.datasource

import android.util.Log
import androidx.room.RoomDatabase
import com.tottus.data.OperationResult
import com.tottus.data.database.TottusDataBase
import com.tottus.data.database.entity.TeamLocal
import com.tottus.data.datasource.LocalTeamDataSource
import com.tottus.domain.entity.TeamDomain
import java.lang.Exception

class LocalTeamDataSourceImpl(private val database: TottusDataBase) : LocalTeamDataSource {
    override suspend fun saveTeam(team: TeamDomain): OperationResult<String> {
        return try {
            val teamLocal = team.toLocal()
            database.getTeamDao().saveTeam(teamLocal)
            OperationResult.Success("Registro Exitoso")

        } catch (e: Exception) {
            Log.e("LocalUserDSI -> ", e.printStackTrace().toString())
            OperationResult.Error("Ocurrio un error")
        }
    }
}