package com.leopold.mvp.presenter

import android.support.annotation.CallSuper
import rx.Subscription
import rx.subscriptions.CompositeSubscription
import java.net.SocketTimeoutException

/**
 * @author Leopold
 */
abstract class BaseFragmentPresenter<T> {
    private var subscriptions: CompositeSubscription? = CompositeSubscription()
    abstract var view: T?

    @CallSuper
    open fun onCreate() {}

    @CallSuper
    open fun onResume() {}

    @CallSuper
    open fun onPause() {}

    @CallSuper
    open fun onStop() {}

    @CallSuper
    open fun onDestroyView() {
        subscriptions?.unsubscribe()
        subscriptions = null
        view = null
    }

    protected fun isTimeoutError(throwable: Throwable): Boolean {
        return throwable is SocketTimeoutException
    }

    protected fun addToSubscribe(subscription: Subscription) {
        subscriptions?.add(subscription)
    }
}