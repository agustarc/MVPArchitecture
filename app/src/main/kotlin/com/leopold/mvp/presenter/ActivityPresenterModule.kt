package com.leopold.mvp.presenter

import android.app.Activity
import com.leopold.mvp.annotation.UserScope
import com.leopold.mvp.presenter.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * @author Leopold
 */
@Module
class ActivityPresenterModule {

    @Provides
    @UserScope
    fun provideMainPresenter(context: Activity): MainPresenter {
        return MainPresenter(context)
    }

}