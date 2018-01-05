package com.leopold.mvp.model

/**
 * @author Leopold
 */
class Pagination<out T> private constructor(var pageNum: Int, var pageSize: Int) where T : Pageable {
    private var count: Int = 0

    companion object {
        private const val FIRST_PAGE: Int = 1
        private const val DEFAULT_PAGE_SIZE: Int = 50

        fun <T> newInstance(pageNum: Int = FIRST_PAGE, pageSize: Int = DEFAULT_PAGE_SIZE): Pagination<T> where T : Pageable {
            return Pagination(pageNum, pageSize)
        }
    }

    fun replace(pageable: Pageable) {
        count = pageable.getTotalCount()
    }

    fun reset() {
        pageNum = FIRST_PAGE
    }

    fun hasNextPage(): Boolean {
        return (pageNum * pageSize) < count
    }

    fun nextPage() {
        if (hasNextPage()) {
            pageNum++
        }
    }
}