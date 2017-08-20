package com.leopold.mvp.ui

import android.os.Bundle

/**
 * @author Leopold
 */
abstract class InjectableActivity : BaseActivity() {
    abstract fun inject(): Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inject()
    }
}