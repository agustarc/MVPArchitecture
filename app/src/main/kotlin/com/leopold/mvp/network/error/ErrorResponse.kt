package com.leopold.mvp.network.error

/**
 * @author Leopold
 */
interface ErrorResponse {
    fun errorCode(): Int
    fun errorMessage(): String
    fun kind(): ErrorKind
}