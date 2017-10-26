package com.leopold.mvp.network

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.GlideModule
import okhttp3.OkHttpClient
import java.io.InputStream
import java.util.concurrent.TimeUnit

/**
 * @author Leopold
 */
class GlideConfiguration : GlideModule {

    companion object {
        private const val DISK_CACHE_SIZE: Int = 1024 * 1024 * 30
        private const val TIMEOUT: Long = 15
        private const val BUFFER_FACTOR: Float = 1.2f
    }

    override fun registerComponents(context: Context?, glide: Glide?) {
        val client: OkHttpClient = OkHttpClient.Builder()
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build()

        glide?.register(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(client))
    }

    override fun applyOptions(context: Context?, builder: GlideBuilder?) {
        val calculator: MemorySizeCalculator = MemorySizeCalculator(context)
        val defaultMemoryCacheSize: Int = calculator.memoryCacheSize
        val defaultBitmapPoolSize: Int = calculator.bitmapPoolSize

        val memoryCacheSize: Int = (BUFFER_FACTOR * defaultMemoryCacheSize).toInt()
        val bitmapCacheSize: Int = (BUFFER_FACTOR * defaultBitmapPoolSize).toInt()

        builder?.run {
            setDecodeFormat(DecodeFormat.PREFER_RGB_565)
            setDiskCache(InternalCacheDiskCacheFactory(context, "image_manager_disk_cache", DISK_CACHE_SIZE))
            setMemoryCache(LruResourceCache(memoryCacheSize))
            setBitmapPool(LruBitmapPool(bitmapCacheSize))
        }
    }
}