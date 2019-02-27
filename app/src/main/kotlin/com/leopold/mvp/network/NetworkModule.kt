package com.leopold.mvp.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.leopold.mvp.App
import com.leopold.mvp.BuildConfig
import com.leopold.mvp.network.error.Rx2ErrorHandlingCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val CONNECT_TIMEOUT: Long = 30
private const val WRITE_TIMEOUT: Long = 30
private const val READ_TIMEOUT: Long = 30

/**
 * @author Leopold
 */
@Module
class NetworkModule {
    private val baseUrl: String = "https://api.github.com"

    @Provides
    @Singleton
    fun provideCache(application: App): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10MB
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideGs(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache, interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .cookieJar(JavaNetCookieJar(CookieManager(null, CookiePolicy.ACCEPT_ALL)))
                .addInterceptor(HttpLoggingInterceptor().apply {
                    if (BuildConfig.DEBUG) {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                })
                .addInterceptor(interceptor)
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gs: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(Rx2ErrorHandlingCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gs))
                .baseUrl(baseUrl)
                .client(client)
                .build()
    }

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor {
        return Interceptor {
            val builder: Request.Builder = it.request().newBuilder()
            builder.header("User-Agent", "Android")

            it.proceed(builder.build())
        }
    }
}