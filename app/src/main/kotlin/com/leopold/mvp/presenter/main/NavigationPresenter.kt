package com.leopold.mvp.presenter.main

import android.support.v4.app.Fragment
import com.leopold.mvp.presenter.BaseFragmentPresenter
import com.leopold.mvp.presenter.NetworkPresenterView

/**
 * @author Leopold
 */
class NavigationPresenter constructor(context: Fragment) : BaseFragmentPresenter<NavigationPresenter.View>() {
    override var view: View? = context as View

    interface View : NetworkPresenterView
}