package com.leopold.mvp.network

import com.leopold.mvp.network.api.UserApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * @author Leopold
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }

}