package com.leopold.mvp.presenter.main

import android.app.Activity
import com.leopold.mvp.presenter.BasePresenter
import com.leopold.mvp.presenter.NetworkPresenterView

/**
 * @author Leopold
 */
class MainPresenter constructor(context: Activity) : BasePresenter() {
    private var view: View? = context as View

    override fun destroy() {
        view = null
    }

    interface View : NetworkPresenterView
}