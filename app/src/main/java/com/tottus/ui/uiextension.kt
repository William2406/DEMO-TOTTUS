package com.tottus.ui

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

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

fun validateInputs(vararg inputs: String): Boolean {
    var value = true
    inputs.forEach {
        if (it.isBlank()) {
            value = false
        }
    }
    return value
}

fun Fragment.showLongMessage(message: String) {
    Toast.makeText(context!!, message, Toast.LENGTH_LONG).show()
}