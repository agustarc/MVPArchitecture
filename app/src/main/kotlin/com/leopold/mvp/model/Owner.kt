package com.leopold.mvp.model

import com.google.gson.annotations.SerializedName

/**
 * @author Leopold
 */
data class Owner(
        @SerializedName("id") val id: Int,
        @SerializedName("login") val login: String,
        @SerializedName("avatar_url") val avatarUrl: String,
        @SerializedName("gravatar_id") val grAvatarId: String,
        @SerializedName("url") val url: String,
        @SerializedName("received_events_url") val receivedEventsUrl: String,
        @SerializedName("type") val type: String
)