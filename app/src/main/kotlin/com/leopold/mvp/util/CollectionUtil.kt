package com.leopold.mvp.util

/**
 * @author Leopold
 */
class CollectionUtil {
    companion object {
        private fun isInvalid(position: Int, collection: List<*>?): Boolean {
            return position < 0 || collection == null || position >= collection.size
        }

        fun <T> get(position: Int, collection: List<T>): T? {
            if (isInvalid(position, collection)) {
                return null
            }

            return collection[position]
        }
    }
}