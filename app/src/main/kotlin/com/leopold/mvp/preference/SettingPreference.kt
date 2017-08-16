package com.leopold.mvp.preference

import android.content.Context
import com.leopold.mvp.constant.PreferenceName

/**
 * @author Leopold
 */
class SettingPreference(context: Context) : CachedPreference(context, PreferenceName.SETTING) {
    private val PUSH_ENABLE = "push_enable"

    fun setPushEnable(enable: Boolean) {
        put(PUSH_ENABLE, enable)
    }

    fun isPushEnable(): Boolean {
        return get(PUSH_ENABLE, false) as Boolean
    }
}