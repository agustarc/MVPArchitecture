package com.leopold.mvp.network.response

import com.google.gson.annotations.SerializedName
import com.leopold.mvp.model.Repository

/**
 * @author Leopold
 */
data class RepositoryResponse(
        @SerializedName("total_count") val totalCount: Int,
        @SerializedName("incomplete_results") val incompleteResults: Boolean,
        @SerializedName("items") val items: ArrayList<Repository>
)