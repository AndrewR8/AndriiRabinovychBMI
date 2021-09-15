package com.example.andriirabinovychbmi.util

import android.view.View

fun View.setOnClickListener(listener: () -> Unit) = setOnClickListener { listener() }

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}
