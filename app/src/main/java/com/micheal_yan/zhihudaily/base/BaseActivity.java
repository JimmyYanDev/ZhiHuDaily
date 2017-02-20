package com.micheal_yan.zhihudaily.base;

import android.app.Activity;
import android.os.Bundle;

import com.micheal_yan.zhihudaily.app.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by micheal-yan on 2017/2/19.
 */

public abstract class BaseActivity<T extends BasePresenter> extends Activity implements BaseView{

    protected T mPresenter;
    protected Activity mContext;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        // 将Activity添加到集合中进行集中管理
        App.getInstance().addActivity(this);
        // 绑定ButterKnife
        mUnbinder = ButterKnife.bind(this);
        mContext = this;
        // 进行数据和事件的初始化操作
        initEventAndData();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 去除对Presenter的引用，防止内存泄漏
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        // 取消绑定ButterKnife
        mUnbinder.unbind();
        // 退出时从集合中移除Activity
        App.getInstance().removeActivity(this);
    }

    protected abstract void initEventAndData();
    protected abstract int getLayout();
}