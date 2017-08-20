package com.leopold.mvp.ui.main

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.leopold.mvp.ActivityModule
import com.leopold.mvp.App
import com.leopold.mvp.R
import com.leopold.mvp.component.DaggerActivityComponent
import com.leopold.mvp.presenter.BasePresenter
import com.leopold.mvp.presenter.PresenterModule
import com.leopold.mvp.presenter.main.MainPresenter
import com.leopold.mvp.ui.PresenterActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * @author Leopold
 */
class MainActivity : PresenterActivity(), MainPresenter.View {
    private lateinit var drawerToggle: ActionBarDrawerToggle

    @Inject lateinit var presenter: MainPresenter

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun getPresenter(): BasePresenter? {
        return presenter
    }

    override fun inject() {
        DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent(this))
                .activityModule(ActivityModule(this))
                .presenterModule(PresenterModule())
                .build().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setDrawerToggle()
    }

    override fun onDestroy() {
        drawer?.removeDrawerListener(drawerToggle)
        super.onDestroy()
    }

    private fun setDrawerToggle() {
        setSupportActionBar(toolbar)

        drawerToggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.general_empty, R.string.general_empty)
        drawerToggle.syncState()
        drawer.addDrawerListener(drawerToggle)
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
}