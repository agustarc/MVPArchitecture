package com.leopold.mvp.preference

import com.leopold.mvp.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Leopold
 */
@Module
class PreferenceModule {

    @Provides
    @Singleton
    fun provideSettingPreference(app: App) = SettingPreference(app)

}