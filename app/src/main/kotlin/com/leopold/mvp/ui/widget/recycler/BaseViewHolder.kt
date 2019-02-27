package com.leopold.mvp.ui.widget.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Leopold
 */
open class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun setOnItemClickListener(view: View, listener: OnItemClickListener?) {
        view.setOnClickListener { listener?.onItemClick(view, adapterPosition) }
    }
}