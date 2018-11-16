package ru.iandreyshev.coreAndroid.ui.dialog

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import org.jetbrains.anko.AlertBuilder
import org.jetbrains.anko.alert
import org.jetbrains.anko.appcompat.v7.Appcompat

fun Fragment.buildAlert(init: AlertBuilder<AlertDialog>.() -> Unit): AlertDialog? {
    return context?.alert(Appcompat) {
        this.apply(init)
    }?.build()
}

fun Activity.buildAlert(init: AlertBuilder<AlertDialog>.() -> Unit): AlertDialog? {
    return alert(Appcompat) {
        this.apply(init)
    }.build()
}

infix fun AlertDialog?.customizeAndShow(customizer: AlertDialog.() -> Unit) =
        this?.apply(customizer)?.show()
