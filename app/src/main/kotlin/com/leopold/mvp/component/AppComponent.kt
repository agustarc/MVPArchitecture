package com.leopold.mvp.component

import com.leopold.mvp.AppModule
import com.leopold.mvp.network.NetworkModule
import com.leopold.mvp.preference.PreferenceModule
import com.leopold.mvp.preference.SettingPreference
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Leopold
 */
@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        PreferenceModule::class,
        NetworkModule::class)
)
interface AppComponent {
    fun retrofit(): Retrofit
    fun setting(): SettingPreference
}