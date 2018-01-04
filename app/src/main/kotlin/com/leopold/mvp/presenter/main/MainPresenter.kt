package com.leopold.mvp.presenter.main

import android.app.Activity
import com.leopold.mvp.App
import com.leopold.mvp.component.DaggerPresenterComponent
import com.leopold.mvp.model.Repository
import com.leopold.mvp.network.ApiModule
import com.leopold.mvp.network.ApiQueryParam
import com.leopold.mvp.network.RxObservableConverter
import com.leopold.mvp.network.api.GitHubApi
import com.leopold.mvp.presenter.BasePresenter
import com.leopold.mvp.presenter.NetworkPresenterView
import javax.inject.Inject

/**
 * @author Leopold
 */
class MainPresenter constructor(context: Activity) : BasePresenter<MainPresenter.View>() {
    override var view: View? = context as View
    @Inject lateinit var api: GitHubApi

    init {
        DaggerPresenterComponent.builder()
                .appComponent(App.getAppComponent(context))
                .apiModule(ApiModule())
                .build().inject(this)
    }

    fun searchRepositories() {
        view?.run {
            this.showProgress()

            val params: MutableMap<String, String> = mutableMapOf()
            params[ApiQueryParam.QUERY] = "Android"
            params[ApiQueryParam.SORT] = "stars"
            params[ApiQueryParam.ORDER] = "asc"

            addToDisposable(RxObservableConverter.forNetwork(api.searchRepositories(params))
                    .subscribe({
                        this.hideProgress()
                        this.setAdapter(it.items)
                    }, {
                        this.hideProgress()

                    }))
        }
    }

    interface View : NetworkPresenterView {
        fun showProgress()
        fun hideProgress()
        fun setAdapter(repositories: ArrayList<Repository>)
    }
}