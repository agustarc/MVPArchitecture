package com.leopold.mvp.network

import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

/**
 * @author JoongWon Baik
 * Kolon Corp
 * joongwon_baik@kolon.com
 */
abstract class GlideSimpleListener<T, R> : RequestListener<T, R> {

    override fun onException(e: Exception?, model: T, target: Target<R>?, isFirstResource: Boolean): Boolean {
        return false
    }

    override fun onResourceReady(resource: R, model: T, target: Target<R>?, isFromMemoryCache: Boolean, isFirstResource: Boolean): Boolean {
        onResourceReady(resource, model)
        return false
    }

    abstract fun onResourceReady(resource:R, model: T): Boolean
}