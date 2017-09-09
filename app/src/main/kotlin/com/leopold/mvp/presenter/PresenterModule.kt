package com.leopold.mvp.presenter

import android.app.Activity
import android.support.v4.app.Fragment
import com.leopold.mvp.annotation.UserScope
import com.leopold.mvp.presenter.main.MainPresenter
import com.leopold.mvp.presenter.main.NavigationPresenter
import dagger.Module
import dagger.Provides

/**
 * @author Leopold
 */
@Module
class PresenterModule {

    @Provides
    @UserScope
    fun provideMainPresenter(context: Activity): MainPresenter  {
        return MainPresenter(context)
    }

    @Provides
    @UserScope
    fun provideNavigationPresenter(context: Fragment): NavigationPresenter  {
        return NavigationPresenter(context)
    }
}