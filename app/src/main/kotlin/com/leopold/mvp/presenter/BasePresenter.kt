package com.leopold.mvp.presenter

import android.support.annotation.CallSuper
import com.leopold.mvp.model.Pageable
import com.leopold.mvp.model.Pagination
import com.leopold.mvp.network.ApiQueryParam
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.net.SocketTimeoutException

/**
 * @author Leopold
 */
@Suppress("unused")
abstract class BasePresenter<T> {
    private var disposables: CompositeDisposable? = CompositeDisposable()
    abstract var view: T?

    @CallSuper
    open fun onCreate() {
    }

    @CallSuper
    open fun onResume() {
    }

    @CallSuper
    open fun onPause() {
    }

    @CallSuper
    open fun onStop() {
    }

    @CallSuper
    fun onDestroy() {
        disposables?.clear()
        disposables = null
        view = null
    }

    protected fun isTimeoutError(throwable: Throwable) = throwable is SocketTimeoutException

    protected fun getPageParams(pagination: Pagination<Pageable>) =
            mutableMapOf<String, String>().apply {
                this[ApiQueryParam.PAGE] = pagination.pageNum.toString()
                this[ApiQueryParam.PER_PAGE] = pagination.pageSize.toString()
            }

    protected fun addToDisposable(disposable: Disposable) {
        disposables?.add(disposable)
    }
}