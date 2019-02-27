package com.leopold.mvp

import androidx.fragment.app.Fragment
import com.leopold.mvp.annotation.UserScope
import dagger.Module
import dagger.Provides

/**
 * @author Leopold
 */
@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @UserScope
    fun provideFragment() = fragment
}