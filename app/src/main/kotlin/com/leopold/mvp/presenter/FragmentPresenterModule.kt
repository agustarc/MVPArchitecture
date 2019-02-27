package com.leopold.mvp.presenter

import androidx.fragment.app.Fragment
import com.leopold.mvp.annotation.UserScope
import com.leopold.mvp.presenter.main.NavigationPresenter
import dagger.Module
import dagger.Provides

/**
 * @author Leopold
 */
@Module
class FragmentPresenterModule {

    @Provides
    @UserScope
    fun provideNavigationPresenter(context: Fragment) = NavigationPresenter(context)

}