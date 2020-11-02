package com.tottus.ui

import android.content.Context
import android.widget.Toast

fun Context.showLongMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.validateInputs(vararg inputs: String): Boolean {
    var value = true
    inputs.forEach {
        if (it.isBlank()) {
            value = false
        }
    }
    return value
}