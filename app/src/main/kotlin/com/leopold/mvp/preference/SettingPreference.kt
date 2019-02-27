package com.leopold.mvp.preference

import android.content.Context

private const val PUSH_ENABLE = "push_enable"
private const val NAME = "pref_setting"

/**
 * @author Leopold
 */
class SettingPreference(context: Context) : CachedPreference(context, NAME) {

    fun setPushEnable(enable: Boolean) = put(PUSH_ENABLE, enable)

    fun isPushEnable() = get(PUSH_ENABLE, false) as Boolean
}