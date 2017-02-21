package com.micheal_yan.zhihudaily.presenter;

import com.micheal_yan.zhihudaily.presenter.contract.MainContract;

/**
 * Created by micheal-yan on 2017/2/21.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    @Override
    public void attachView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
