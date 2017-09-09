package com.leopold.mvp.presenter.main

import android.app.Activity
import com.leopold.mvp.presenter.BasePresenter
import com.leopold.mvp.presenter.NetworkPresenterView

/**
 * @author Leopold
 */
class MainPresenter constructor(context: Activity) : BasePresenter<MainPresenter.View>() {
    override var view: View? = context as View

    interface View : NetworkPresenterView
}