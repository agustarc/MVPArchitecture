package com.leopold.mvp.network

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiPredicate
import io.reactivex.schedulers.Schedulers

/**
 * @author Leopold
 */
class RxObservableConverter {

    companion object {

        fun <T> forNetwork(observable: Observable<T>): Observable<T> {
            return observable
                    .retry(RetryPolicy.default())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }

        fun <T> forNetwork(observable: Observable<T>, retry: BiPredicate<Int, Throwable>): Observable<T> {
            return observable
                    .retry(retry)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }

        fun <T> forFile(observable: Observable<T>): Observable<T> {
            return observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

}