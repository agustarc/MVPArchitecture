package com.leopold.mvp.network

import com.leopold.mvp.annotation.UserScope
import com.leopold.mvp.network.api.UserApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * @author Leopold
 */
@Module
class ApiModule {

    @Provides
    @UserScope
    fun provideUserApi(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }

}