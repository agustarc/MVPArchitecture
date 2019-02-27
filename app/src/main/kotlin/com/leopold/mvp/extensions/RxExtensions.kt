package com.leopold.mvp.extensions

import com.leopold.mvp.network.RetryPolicy
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author Leopold
 */

fun <T> Observable<T>.forNetwork(): Observable<T> = retry(RetryPolicy.default()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())