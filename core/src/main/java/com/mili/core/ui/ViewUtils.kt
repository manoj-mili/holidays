package com.mili.core.ui

import android.view.View

fun View.updateVisibility(visible: Boolean) {
    if (visible) this.visibility = View.VISIBLE else this.visibility = View.GONE
}