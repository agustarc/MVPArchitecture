package com.leopold.mvp.network

import com.leopold.mvp.annotation.UserScope
import com.leopold.mvp.network.api.GitHubApi
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
    fun provideGitHubApi(retrofit: Retrofit): GitHubApi = retrofit.create(GitHubApi::class.java)

}