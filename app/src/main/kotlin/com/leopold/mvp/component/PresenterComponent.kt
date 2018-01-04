package com.leopold.mvp.component

import com.leopold.mvp.annotation.UserScope
import com.leopold.mvp.network.ApiModule
import com.leopold.mvp.presenter.main.MainPresenter
import com.leopold.mvp.presenter.main.NavigationPresenter
import dagger.Component

/**
 * @author Leopold
 */
@UserScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ApiModule::class))
interface PresenterComponent {
    fun inject(presenter: MainPresenter)
    fun inject(presenter: NavigationPresenter)
}