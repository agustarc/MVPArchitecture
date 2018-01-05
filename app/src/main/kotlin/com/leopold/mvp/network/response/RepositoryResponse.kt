package com.leopold.mvp.network.response

import com.google.gson.annotations.SerializedName
import com.leopold.mvp.model.Pageable
import com.leopold.mvp.model.repository.Repository

/**
 * @author Leopold
 */
data class RepositoryResponse(
        @SerializedName("total_count") val count: Int,
        @SerializedName("incomplete_results") val incompleteResults: Boolean,
        @SerializedName("items") val items: ArrayList<Repository>
) : Pageable {
    override fun getTotalCount(): Int {
        return count
    }
}