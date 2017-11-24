package com.leopold.mvp.network

import io.reactivex.functions.BiPredicate
import java.net.SocketTimeoutException

/**
 * @author Leopold
 */
@Suppress("UNUSED_PARAMETER")
class RetryPolicy {
    companion object {
        private val HIGH: Int = 3
        private val MEDIUM: Int = 2
        private val LOW: Int = 1

        fun default(): BiPredicate<Int, Throwable> {
            return BiPredicate { retryCount, throwable -> retryCount <= LOW && throwable is SocketTimeoutException }
        }

        fun socketTimeout(): BiPredicate<Int, Throwable> {
            return BiPredicate { retryCount, throwable -> retryCount <= MEDIUM && throwable is SocketTimeoutException }
        }

        fun authorization(): BiPredicate<Int, Throwable> {
            return BiPredicate { retryCount, throwable -> retryCount <= HIGH && throwable is SocketTimeoutException }
        }

        fun none(): BiPredicate<Int, Throwable> {
            return BiPredicate { retryCount, throwable ->  false }
        }
    }
}