package com.leopold.mvp.component

import com.leopold.mvp.AppModule
import com.leopold.mvp.network.ApiModule
import com.leopold.mvp.network.NetworkModule
import com.leopold.mvp.network.api.UserApi
import com.leopold.mvp.preference.PreferenceModule
import com.leopold.mvp.preference.SettingPreference
import dagger.Component
import javax.inject.Singleton

/**
 * @author Leopold
 */
@Singleton
@Component(modules = arrayOf(
        ApiModule::class,
        AppModule::class,
        PreferenceModule::class,
        NetworkModule::class)
)
interface AppComponent {
    fun user(): UserApi
    fun setting(): SettingPreference
}