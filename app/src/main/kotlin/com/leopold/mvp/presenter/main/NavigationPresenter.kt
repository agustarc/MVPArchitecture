package com.leopold.mvp.presenter.main

import android.support.v4.app.Fragment
import com.leopold.mvp.App
import com.leopold.mvp.component.DaggerPresenterComponent
import com.leopold.mvp.presenter.BaseFragmentPresenter
import com.leopold.mvp.presenter.PresenterView

/**
 * @author Leopold
 */
class NavigationPresenter constructor(context: Fragment) : BaseFragmentPresenter<NavigationPresenter.View>() {
    override var view: View? = context as View

    init {
        context.context?.run {
            DaggerPresenterComponent.builder()
                    .appComponent(App.getAppComponent(this))
                    .build().inject(this@NavigationPresenter)
        }
    }

    interface View : PresenterView
}