package com.leopold.mvp

import android.app.Application
import android.content.Context
import com.leopold.mvp.component.AppComponent
import com.leopold.mvp.component.DaggerAppComponent
import com.leopold.mvp.network.NetworkModule
import com.leopold.mvp.preference.PreferenceModule

/**
 * @author Leopold
 */
class App : Application() {

    val singleton: AppComponent by lazy {
        DaggerAppComponent.builder()
                .networkModule(NetworkModule())
                .preferenceModule(PreferenceModule())
                .appModule(AppModule(this))
                .build()
    }

    companion object {
        fun getAppComponent(context: Context): AppComponent {
            return (context.applicationContext as App).singleton
        }
    }
}