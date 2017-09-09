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
    fun onCreate(): Unit {}

    @CallSuper
    fun onResume(): Unit {}

    @CallSuper
    fun onPause(): Unit {}

    @CallSuper
    fun onStop(): Unit {}

    @CallSuper
    fun onDestroyView(): Unit {
        subscriptions?.unsubscribe()
        subscriptions = null
        view = null
    }

    protected fun isTimeoutError(throwable: Throwable): Boolean {
        return throwable is SocketTimeoutException
    }

    protected fun addToSubscribe(subscription: Subscription): Unit {
        subscriptions?.add(subscription)
    }
}