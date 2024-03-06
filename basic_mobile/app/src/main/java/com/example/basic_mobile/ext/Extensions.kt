package com.example.basic_mobile.ext

import android.view.View
import com.example.basic_mobile.utils.OnOneOffClickListener


fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
    try {
        val safeClickListener = OnOneOffClickListener {
            onSafeClick(it)
        }
        setOnClickListener(safeClickListener)
    } catch (E: Exception) {
    }
}