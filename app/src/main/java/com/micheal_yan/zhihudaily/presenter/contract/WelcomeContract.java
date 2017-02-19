package com.micheal_yan.zhihudaily.presenter.contract;

import com.micheal_yan.zhihudaily.base.BasePresenter;
import com.micheal_yan.zhihudaily.base.BaseView;
import com.micheal_yan.zhihudaily.model.bean.GankItemBean;

/**
 * Created by micheal-yan on 2017/2/19.
 */

public interface WelcomeContract {

    interface View extends BaseView<Presenter> {

        void showContent(GankItemBean gankItemBean);

        void jumpToMain();
    }

    interface Presenter extends BasePresenter {

        void getWelcomeData();
    }
}
