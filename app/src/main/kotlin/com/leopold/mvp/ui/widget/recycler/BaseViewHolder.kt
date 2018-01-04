package com.leopold.mvp.ui.widget.recycler

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * @author Leopold
 */
open class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun setOnItemClickListener(view: View, listener: OnItemClickListener?) {
        view.setOnClickListener { listener?.onItemClick(view, adapterPosition) }
    }
}