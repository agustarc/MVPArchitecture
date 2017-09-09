package com.leopold.mvp.ui

import android.content.Context
import android.support.annotation.CallSuper
import android.support.annotation.NonNull
import android.support.v4.app.Fragment

/**
 * @author Leopold
 */
abstract class InjectableFragment : BaseFragment() {
    protected abstract fun inject(@NonNull fragment: Fragment): Unit

    @CallSuper
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        inject(this)
    }
}