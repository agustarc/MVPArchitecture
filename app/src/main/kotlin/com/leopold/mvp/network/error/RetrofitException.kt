package com.leopold.mvp.network.error

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * @author Leopold
 */
class RetrofitException(override val message: String?,
                        private val response: Response<*>?,
                        val kind: ErrorKind,
                        private val exception: Throwable?,
                        val retrofit: Retrofit?) : RuntimeException(message, exception) {

    fun isTimeout(): Boolean {
        return exception is SocketTimeoutException
    }

    fun <T> getErrorBodyAs(type: Class<T>): T? {
        if (retrofit == null || response == null || response.errorBody() == null) {
            return null
        }

        val converter: Converter<ResponseBody, T> = retrofit.responseBodyConverter(type, arrayOf())
        return converter.convert(response.errorBody())
    }

    companion object {
        fun httpError(response: Response<*>, retrofit: Retrofit?): RetrofitException {
            val message: String = response.code().toString() + " " + response.message()
            return RetrofitException(message, response, ErrorKind.HTTP, null, retrofit)
        }

        fun networkError(exception: IOException): RetrofitException {
            return RetrofitException(exception.message, null, ErrorKind.NETWORK, exception, null)
        }

        fun unexpectedError(exception: Throwable): RetrofitException {
            return RetrofitException(exception.message, null, ErrorKind.UNEXPECTED, exception, null)
        }
    }
}