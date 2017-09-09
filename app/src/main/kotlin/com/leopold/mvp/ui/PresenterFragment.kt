package com.leopold.mvp.ui

import android.os.Bundle
import com.leopold.mvp.presenter.BaseFragmentPresenter

/**
 * @author Leopold
 */
abstract class PresenterFragment<T> : InjectableFragment() {
    protected abstract fun getPresenter(): BaseFragmentPresenter<T>?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPresenter()?.onCreate()
    }

    override fun onResume() {
        super.onResume()
        getPresenter()?.onResume()
    }

    override fun onPause() {
        super.onPause()
        getPresenter()?.onPause()
    }

    override fun onStop() {
        super.onStop()
        getPresenter()?.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        getPresenter()?.onDestroyView()
    }
}