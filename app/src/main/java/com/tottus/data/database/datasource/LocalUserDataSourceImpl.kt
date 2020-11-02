package com.tottus.data.database.datasource

import android.util.Log
import com.tottus.data.OperationResult
import com.tottus.data.database.TottusDataBase
import com.tottus.data.datasource.LocalUserDataSource
import com.tottus.domain.entity.UserDomain
import java.lang.Exception

class LocalUserDataSourceImpl(private val database: TottusDataBase) : LocalUserDataSource {
    override suspend fun saveUser(user: UserDomain): OperationResult<String> {
        return try {
            val userLocal = user.toLocal()
            if (database.getUserDao().userVerify(userLocal.email) == null){
                database.getUserDao().saveUser(userLocal)
                OperationResult.Success("Registro Exitoso")
            }else{
                OperationResult.Error("El usuario ya existe")
            }
        } catch (e: Exception) {
            Log.e("LocalUserDSI -> ", e.printStackTrace().toString())
            OperationResult.Error("Ocurrio un error")
        }
    }
}