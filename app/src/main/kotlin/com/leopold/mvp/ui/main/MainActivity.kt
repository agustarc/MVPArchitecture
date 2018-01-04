package com.leopold.mvp.ui.main

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.view.View
import com.leopold.mvp.ActivityModule
import com.leopold.mvp.App
import com.leopold.mvp.R
import com.leopold.mvp.component.DaggerActivityComponent
import com.leopold.mvp.extensions.setToolbar
import com.leopold.mvp.model.Repository
import com.leopold.mvp.network.error.ErrorResponse
import com.leopold.mvp.presenter.ActivityPresenterModule
import com.leopold.mvp.presenter.BasePresenter
import com.leopold.mvp.presenter.main.MainPresenter
import com.leopold.mvp.ui.PresenterActivity
import com.leopold.mvp.ui.widget.recycler.OnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * @author Leopold
 */
class MainActivity : PresenterActivity<MainPresenter.View>(), MainPresenter.View, OnItemClickListener {
    private lateinit var drawerToggle: ActionBarDrawerToggle
    @Inject lateinit var presenter: MainPresenter
    private var adapter: RepositoryRecyclerAdapter? = null

    private val toolbar by lazy { main_toolbar }
    private val refreshLayout by lazy { main_refresh_layout }
    private val recyclerView by lazy { main_recycler_view }

    override fun getPresenter(): BasePresenter<MainPresenter.View>? {
        return presenter
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun inject() {
        DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent(this))
                .activityModule(ActivityModule(this))
                .activityPresenterModule(ActivityPresenterModule())
                .build().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setToolbar(toolbar, R.string.app_name)

        refreshLayout.isEnabled = false

        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = LinearLayoutManager(this)

        presenter.searchRepositories()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        drawerToggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.general_empty, R.string.general_empty).apply {
            syncState()
            drawer.addDrawerListener(this)
        }
    }

    override fun onDestroy() {
        drawer?.removeDrawerListener(drawerToggle)
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item)
    }

    override fun showProgress() {
        refreshLayout.isRefreshing = true
    }

    override fun hideProgress() {
        refreshLayout.isRefreshing = false
    }

    override fun setAdapter(repositories: ArrayList<Repository>) {
        if (adapter == null) {
            adapter = RepositoryRecyclerAdapter(this, repositories).apply {
                setOnItemClickListener(this@MainActivity)
                recyclerView.adapter = this
            }
        } else {
            adapter?.replace(repositories)
        }
    }

    override fun onItemClick(view: View, position: Int) {

    }

    override fun handleNetworkError(error: ErrorResponse) {

    }
}