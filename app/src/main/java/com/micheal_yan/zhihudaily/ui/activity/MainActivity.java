package com.micheal_yan.zhihudaily.ui.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.micheal_yan.zhihudaily.R;
import com.micheal_yan.zhihudaily.base.BaseActivity;
import com.micheal_yan.zhihudaily.presenter.MainPresenter;
import com.micheal_yan.zhihudaily.presenter.contract.MainContract;
import com.micheal_yan.zhihudaily.ui.fragment.ColumnFragment;
import com.micheal_yan.zhihudaily.ui.fragment.HotFragment;
import com.micheal_yan.zhihudaily.ui.fragment.DailyFragment;
import com.micheal_yan.zhihudaily.ui.fragment.ThemeFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter>
        implements NavigationView.OnNavigationItemSelectedListener, MainContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    ActionBarDrawerToggle toggle;

    private FragmentManager mFragmentManager;
    private DailyFragment mDailyFragment;
    private HotFragment mHotFragment;
    private ThemeFragment mThemeFragment;
    private ColumnFragment mColumnFragment;

    @Override
    protected void initEventAndData() {

        mPresenter = new MainPresenter();

        toolbar.setTitle("日报");
        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        mFragmentManager = getSupportFragmentManager();
        mDailyFragment = new DailyFragment();
        mThemeFragment = new ThemeFragment();
        mColumnFragment = new ColumnFragment();
        mHotFragment = new HotFragment();

        mFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, mDailyFragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            toolbar.setTitle("日报");
            mFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, mDailyFragment)
                    .commit();
        } else if (id == R.id.nav_theme) {
            toolbar.setTitle("主题");
            mFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, mThemeFragment)
                    .commit();

        } else if (id == R.id.nav_column) {
            toolbar.setTitle("专栏");
            mFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, mColumnFragment)
                    .commit();

        } else if (id == R.id.nav_hot) {
            toolbar.setTitle("热门");
            mFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, mHotFragment)
                    .commit();

        } else if (id == R.id.nav_setting) {
            toolbar.setTitle("设置");

        } else if (id == R.id.nav_about) {
            toolbar.setTitle("关于");

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showError(String msg) {

    }
}
