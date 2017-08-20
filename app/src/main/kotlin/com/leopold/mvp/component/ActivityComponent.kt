package com.leopold.mvp.component

import com.leopold.mvp.ActivityModule
import com.leopold.mvp.annotation.UserScope
import com.leopold.mvp.presenter.PresenterModule
import com.leopold.mvp.ui.main.MainActivity
import dagger.Component

/**
 * @author Leopold
 */
@UserScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(
        PresenterModule::class,
        ActivityModule::class)
)
interface ActivityComponent {
    fun inject(context: MainActivity): Unit
}