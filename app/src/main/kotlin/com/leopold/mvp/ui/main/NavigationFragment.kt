package com.leopold.mvp.ui.main

import android.support.v4.app.Fragment
import com.leopold.mvp.App
import com.leopold.mvp.FragmentModule
import com.leopold.mvp.R
import com.leopold.mvp.component.DaggerFragmentComponent
import com.leopold.mvp.presenter.BaseFragmentPresenter
import com.leopold.mvp.presenter.PresenterModule
import com.leopold.mvp.presenter.main.NavigationPresenter
import com.leopold.mvp.ui.PresenterFragment
import javax.inject.Inject

/**
 * @author Leopold
 */
class NavigationFragment : PresenterFragment<NavigationPresenter.View>(), NavigationPresenter.View {
    @Inject lateinit var presenter: NavigationPresenter

    override fun getPresenter(): BaseFragmentPresenter<NavigationPresenter.View>? {
        return presenter
    }

    override fun inject(fragment: Fragment) {
        DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent(fragment.context))
                .fragmentModule(FragmentModule(this))
                .presenterModule(PresenterModule())
                .build().inject(this)
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_navigation
    }

}