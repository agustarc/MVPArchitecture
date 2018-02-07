package com.leopold.mvp.extensions

import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

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