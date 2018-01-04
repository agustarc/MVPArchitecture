package com.leopold.mvp.model

import com.google.gson.annotations.SerializedName

/**
 * @author Leopold
 */
data class Repository(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("full_name") val fullName: String,
        @SerializedName("owner") val owner: Owner,
        @SerializedName("description") val description: String?
)