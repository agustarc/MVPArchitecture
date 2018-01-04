package com.leopold.mvp.presenter

import com.leopold.mvp.network.error.ErrorResponse

/**
 * @author Leopold
 */
interface NetworkPresenterView : PresenterView {
    fun handleNetworkError(error: ErrorResponse)
}