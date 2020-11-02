package com.tottus.data

sealed class OperationResult<out T> {
    data class Success<T>(val result: T) : OperationResult<T>()
    data class Error(val error:String): OperationResult<Nothing>()
}