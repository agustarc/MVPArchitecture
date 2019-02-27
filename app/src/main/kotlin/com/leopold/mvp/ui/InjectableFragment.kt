package com.leopold.mvp.ui

import android.content.Context
import android.support.annotation.CallSuper
import android.support.annotation.NonNull
import androidx.fragment.app.Fragment

/**
 * @author Leopold
 */
abstract class InjectableFragment : BaseFragment() {
    protected abstract fun inject(@NonNull fragment: Fragment)

    @CallSuper
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        inject(this)
    }
}