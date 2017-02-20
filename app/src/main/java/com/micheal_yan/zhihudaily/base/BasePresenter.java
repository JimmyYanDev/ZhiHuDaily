package com.micheal_yan.zhihudaily.base;

/**
 * Created by micheal-yan on 2017/2/19.
 */

public interface BasePresenter<T extends BaseView>{

        void attachView(T view);

        void detachView();

}
