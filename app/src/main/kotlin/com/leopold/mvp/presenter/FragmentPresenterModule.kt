package com.leopold.mvp.presenter

import android.support.v4.app.Fragment
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
    fun provideNavigationPresenter(context: Fragment): NavigationPresenter {
        return NavigationPresenter(context)
    }

}