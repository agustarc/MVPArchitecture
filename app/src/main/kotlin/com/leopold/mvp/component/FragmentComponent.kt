package com.leopold.mvp.component

import com.leopold.mvp.FragmentModule
import com.leopold.mvp.annotation.UserScope
import com.leopold.mvp.presenter.PresenterModule
import com.leopold.mvp.ui.main.NavigationFragment
import dagger.Component

/**
 * @author Leopold
 */
@UserScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(
        PresenterModule::class,
        FragmentModule::class)
)
interface FragmentComponent  {
    fun inject(context: NavigationFragment): Unit
}