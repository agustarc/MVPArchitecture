package com.leopold.mvp.network.api

import com.leopold.mvp.network.response.RepositoryResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * @author Leopold
 */
interface GitHubApi {

    @GET("/search/repositories")
    fun searchRepositories(@QueryMap params: Map<String, String>): Observable<RepositoryResponse>

}