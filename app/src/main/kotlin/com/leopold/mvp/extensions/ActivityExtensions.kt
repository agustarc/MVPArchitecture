package com.leopold.mvp.extensions

import android.support.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

/**
 * @author Leopold
 */

fun AppCompatActivity.setToolbar(toolbar: Toolbar, @StringRes titleResId: Int) {
    setSupportActionBar(toolbar)
    toolbar.setNavigationOnClickListener { onBackPressed() }

    supportActionBar?.title = getString(titleResId)
}

fun AppCompatActivity.setToolbar(toolbar: Toolbar, title: String) {
    setSupportActionBar(toolbar)
    toolbar.setNavigationOnClickListener { onBackPressed() }

    supportActionBar?.title = title
}