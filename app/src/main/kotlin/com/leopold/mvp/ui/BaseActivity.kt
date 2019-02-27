package com.leopold.mvp.ui

import android.os.Bundle
import android.support.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 * @author Leopold
 */
abstract class BaseActivity : AppCompatActivity() {
    @LayoutRes
    abstract fun getLayoutResId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
    }
}