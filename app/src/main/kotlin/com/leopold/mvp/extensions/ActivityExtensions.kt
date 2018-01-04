package com.leopold.mvp.extensions

import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

/**
 * @author Leopold
 */

fun AppCompatActivity.setToolbar(toolbar: Toolbar, @StringRes titleResId: Int) {
    this.setSupportActionBar(toolbar)
    toolbar.setNavigationOnClickListener { this.onBackPressed() }

    this.supportActionBar?.title = this.getString(titleResId)
}

fun AppCompatActivity.setToolbar(toolbar: Toolbar, title: String) {
    this.setSupportActionBar(toolbar)
    toolbar.setNavigationOnClickListener { this.onBackPressed() }

    this.supportActionBar?.title = title
}