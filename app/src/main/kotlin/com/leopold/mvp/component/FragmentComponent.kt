package com.leopold.mvp.component

import com.leopold.mvp.FragmentModule
import com.leopold.mvp.annotation.UserScope
import com.leopold.mvp.presenter.FragmentPresenterModule
import com.leopold.mvp.ui.main.NavigationFragment
import dagger.Component

/**
 * @author Leopold
 */
@UserScope
@Component(
        dependencies = [AppComponent::class],
        modules = [FragmentPresenterModule::class, FragmentModule::class]
)
interface FragmentComponent {
    fun inject(context: NavigationFragment)
}