package com.leopold.mvp

import android.app.Activity
import com.leopold.mvp.annotation.UserScope
import dagger.Module
import dagger.Provides

/**
 * @author Leopold
 */
@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @UserScope
    fun provideActivity() = activity
}