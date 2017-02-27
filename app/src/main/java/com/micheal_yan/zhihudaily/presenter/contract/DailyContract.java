package com.micheal_yan.zhihudaily.presenter.contract;

import com.micheal_yan.zhihudaily.base.BasePresenter;
import com.micheal_yan.zhihudaily.base.BaseView;
import com.micheal_yan.zhihudaily.model.bean.DailyListBean;

/**
 * Created by micheal-yan on 2017/2/25.
 */

public interface DailyContract {

    interface View extends BaseView {

        void showContent(DailyListBean info);
    }

    interface Presenter extends BasePresenter<View> {

        void getDailyData();
    }
}
