package com.micheal_yan.zhihudaily.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.micheal_yan.zhihudaily.R;
import com.micheal_yan.zhihudaily.base.BaseFragment;
import com.micheal_yan.zhihudaily.model.bean.DailyListBean;
import com.micheal_yan.zhihudaily.presenter.DailyPrenser;
import com.micheal_yan.zhihudaily.presenter.contract.DailyContract;
import com.micheal_yan.zhihudaily.ui.activity.DetailActivity;
import com.micheal_yan.zhihudaily.ui.adapter.DailyAdapter;
import com.micheal_yan.zhihudaily.util.InternetUtil;
import com.micheal_yan.zhihudaily.util.SnackbarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by micheal-yan on 2017/2/21.
 */

public class DailyFragment extends BaseFragment<DailyContract.Presenter> implements DailyContract.View {

    @BindView(R.id.rv_daily_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    DailyAdapter mAdapter;
    List<DailyListBean.StoriesBean> mList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_daily, container, false);
    }

    @Override
    protected void initEventAndData() {
        mPresenter = new DailyPrenser();
        mPresenter.getDailyData();
        mAdapter = new DailyAdapter();
        mAdapter.setOnItemClickListener(new DailyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View shareView) {
                SnackbarUtil.show(mRecyclerView, "打开详情页面");
                Intent intent = new Intent();
                intent.setClass(mContext, DetailActivity.class);
                intent.putExtra("id", mList.get(position).getId());
                mContext.startActivity(intent);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (InternetUtil.isNetworkConnected()) {
                    mPresenter.getDailyData();
                } else {
                    showError("网络不可用");
                }
            }
        });
    }

    @Override
    public void showError(String msg) {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
        SnackbarUtil.show(mRecyclerView, msg);
    }

    @Override
    public void showContent(DailyListBean info) {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
        mList = info.getStories();
        mAdapter.addDailyDate(info);
    }
}
