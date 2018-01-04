package com.leopold.mvp.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.leopold.mvp.R
import com.leopold.mvp.model.Repository
import com.leopold.mvp.ui.widget.recycler.BaseRecyclerAdapter
import com.leopold.mvp.ui.widget.recycler.BaseViewHolder
import com.leopold.mvp.ui.widget.recycler.OnItemClickListener
import com.leopold.mvp.ui.widget.recycler.RecyclerViewType
import kotlinx.android.synthetic.main.layout_repository_item.view.*

/**
 * @author Leopold
 */
class RepositoryRecyclerAdapter constructor(context: Context, repositories: ArrayList<Repository>) : BaseRecyclerAdapter<Repository>(context, repositories) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            RecyclerViewType.VIEW_TYPE_ITEM -> {
                return RepositoryViewHolder(inflater.inflate(R.layout.layout_repository_item, parent, false), listener)
            }

            else -> throw UnsupportedOperationException("Unsupported viewType : " + viewType)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val viewType: Int = getItemViewType(position)
        if (viewType == RecyclerViewType.VIEW_TYPE_ITEM) {
            onBindRepositoryViewHolder(holder as RepositoryViewHolder, position)
        }
    }

    private fun onBindRepositoryViewHolder(holder: RepositoryViewHolder, position: Int) {
        getItem(position)?.run {
            setName(holder, this)
            setDescription(holder, this)
        }
    }

    private fun setName(holder: RepositoryViewHolder, repository: Repository) {
        holder.name.text = repository.name
    }

    private fun setDescription(holder: RepositoryViewHolder, repository: Repository) {
        repository.description?.run {
            holder.description.text = this
        }
    }

    class RepositoryViewHolder(view: View, listener: OnItemClickListener?) : BaseViewHolder(view) {
        val name: TextView = view.repository_item_name
        val description: TextView = view.repository_item_description

        init {
            setOnItemClickListener(view, listener)
        }
    }
}