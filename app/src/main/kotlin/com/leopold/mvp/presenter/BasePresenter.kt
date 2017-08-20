package com.leopold.mvp.presenter

import android.support.annotation.CallSuper
import rx.Subscription
import rx.subscriptions.CompositeSubscription
import java.net.SocketTimeoutException

/**
 * @author Leopold
 */
@Suppress("unused")
abstract class BasePresenter {
    private var subscriptions: CompositeSubscription? = CompositeSubscription()
    abstract fun destroy(): Unit

    @CallSuper
    fun onCreate(): Unit {}

    @CallSuper
    fun onResume(): Unit {}

    @CallSuper
    fun onPause(): Unit {}

    @CallSuper
    fun onStop(): Unit {}

    @CallSuper
    fun onDestroy(): Unit {
        subscriptions?.unsubscribe()
        subscriptions = null
        destroy()
    }

    protected fun isTimeoutError(throwable: Throwable): Boolean {
        return throwable is SocketTimeoutException
    }

    protected fun addToSubscribe(subscription: Subscription): Unit {
        subscriptions?.add(subscription)
    }
}