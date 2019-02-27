package com.leopold.mvp.ui.widget.recycler

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.leopold.mvp.util.CollectionUtil
import java.util.*

/**
 * @author Leopold
 */
abstract class BaseRecyclerAdapter<T> constructor(val context: Context, private var items: ArrayList<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val inflater: LayoutInflater = LayoutInflater.from(context)
    var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    open fun getItem(position: Int): T? {
        return CollectionUtil.get(position, items)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return RecyclerViewType.VIEW_TYPE_ITEM
    }

    fun replace(items: ArrayList<T>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun concat(items: ArrayList<T>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}