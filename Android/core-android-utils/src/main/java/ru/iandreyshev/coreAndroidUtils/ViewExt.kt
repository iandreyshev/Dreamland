package ru.iandreyshev.coreAndroidUtils

import android.view.View

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.goneIf(isGone: Boolean) {
    if (isGone) {
        gone()
    }
}

fun View.isVisible(isVisible: Boolean) {
    if (isVisible) {
        visible()
    }
}

fun View.isInvisible(isInvisible: Boolean) {
    if (isInvisible) {
        invisible()
    }
}

fun View.goneIfOrVisible(isGone: Boolean) {
    if (isGone) {
        gone()
    } else {
        visible()
    }
}

fun View.visibleIfOrGone(isVisible: Boolean) {
    if (isVisible) {
        visible()
    } else {
        gone()
    }
}

fun goneAll(vararg views: View) =
        views.forEach { it.gone() }

fun goneAll(views: List<View>) =
        views.forEach { it.gone() }

fun visibleAll(vararg views: View) =
        views.forEach { it.visible() }

fun visibleAll(views: List<View>) =
        views.forEach { it.visible() }
