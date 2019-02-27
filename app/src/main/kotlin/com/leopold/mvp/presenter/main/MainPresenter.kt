package com.leopold.mvp.presenter.main

import android.app.Activity
import com.leopold.mvp.App
import com.leopold.mvp.component.DaggerPresenterComponent
import com.leopold.mvp.constant.LoadingType
import com.leopold.mvp.extensions.forNetwork
import com.leopold.mvp.model.Pagination
import com.leopold.mvp.model.repository.Repository
import com.leopold.mvp.network.ApiModule
import com.leopold.mvp.network.ApiQueryParam
import com.leopold.mvp.network.api.GitHubApi
import com.leopold.mvp.network.response.RepositoryResponse
import com.leopold.mvp.presenter.BasePresenter
import com.leopold.mvp.presenter.NetworkPresenterView
import javax.inject.Inject

/**
 * @author Leopold
 */
class MainPresenter constructor(context: Activity) : BasePresenter<MainPresenter.View>() {
    override var view: View? = context as View
    @Inject
    lateinit var api: GitHubApi

    private var loadingType: LoadingType = LoadingType.NONE
    private val pagination: Pagination<RepositoryResponse> = Pagination.newInstance()

    init {
        DaggerPresenterComponent.builder()
                .appComponent(App.getAppComponent(context))
                .apiModule(ApiModule())
                .build().inject(this)
    }

    fun searchRepositories() {
        view?.run {
            if (loadingType == LoadingType.MORE) {
                this.showMoreProgress()
            } else {
                this.showProgress()
            }

            val params: MutableMap<String, String> = getPageParams(pagination).apply {
                this[ApiQueryParam.QUERY] = "Android"
                this[ApiQueryParam.SORT] = "stars"
                this[ApiQueryParam.ORDER] = "asc"
            }

            addToDisposable(api.searchRepositories(params).forNetwork()
                    .subscribe({
                        this.hideProgress()
                        this.setAdapter(it.items)
                        pagination.replace(it)
                    }, {
                        this.hideProgress()

                    }))
        }
    }

    fun onLoadMore() {
        if (pagination.hasNextPage()) {
            pagination.nextPage()
            loadingType = LoadingType.MORE

            searchRepositories()
        }
    }

    fun onRefresh() {
        pagination.reset()
        loadingType = LoadingType.REFRESH

        searchRepositories()
    }

    fun isMoreLoading() = loadingType == LoadingType.MORE

    interface View : NetworkPresenterView {
        fun showProgress()
        fun showMoreProgress()
        fun hideProgress()
        fun setAdapter(repositories: ArrayList<Repository>)
    }
}