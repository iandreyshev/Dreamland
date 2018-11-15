package ru.iandreyshev.coreAndroid.ui.view

import android.view.View

fun View.setOnClickListener(listener: () -> Unit) {
    setOnClickListener { listener.invoke() }
}
