package com.micheal_yan.zhihudaily.presenter;

import com.micheal_yan.zhihudaily.model.bean.DailyListBean;
import com.micheal_yan.zhihudaily.model.http.ZhiHuApis;
import com.micheal_yan.zhihudaily.presenter.contract.DailyContract;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by micheal-yan on 2017/2/26.
 */

public class DailyPrenser implements DailyContract.Presenter {

    private DailyContract.View mView;
    private ZhiHuApis zhiHUService;
    private Retrofit mRetrofit;

    @Override
    public void getDailyData() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ZhiHuApis.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        zhiHUService = mRetrofit.create(ZhiHuApis.class);
        Observable<DailyListBean> observable = zhiHUService.getDailyList();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<DailyListBean>() {
                    @Override
                    public void call(DailyListBean dailyListBean) {
                        mView.showContent(dailyListBean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("数据加载失败ヽ(≧Д≦)ノ");
                    }
                });

    }

    @Override
    public void attachView(DailyContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
