package com.micheal_yan.zhihudaily.presenter;

import android.util.Log;

import com.micheal_yan.zhihudaily.model.bean.GankItemBean;
import com.micheal_yan.zhihudaily.model.bean.WelcomeBean;
import com.micheal_yan.zhihudaily.model.http.GankApis;
import com.micheal_yan.zhihudaily.model.http.GankHttpResponse;
import com.micheal_yan.zhihudaily.presenter.contract.WelcomeContract;

import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * Created by micheal-yan on 2017/2/19.
 */

public class WelcomePresenter implements WelcomeContract.Presenter {

    private Retrofit mRetrofit;
    private WelcomeContract.View mView;
    private GankApis service;

    private static final int COUNT_DOWN_TIME = 2200;

    @Override
    public void getWelcomeData() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(GankApis.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        service = mRetrofit.create(GankApis.class);

        Observable<GankHttpResponse<List<GankItemBean>>> observable = service.getWelcomeData();
        observable.subscribeOn(Schedulers.io())
                .map(new Func1<GankHttpResponse<List<GankItemBean>>, WelcomeBean>() {

                    @Override
                    public WelcomeBean call(GankHttpResponse<List<GankItemBean>> been) {
                        String imgUrl = been.getResults().get(0).getUrl();
                        String who = "图片由" + been.getResults().get(0).getWho() + "提供";
                        Log.e("qmyan", imgUrl);
                        return new WelcomeBean(imgUrl, who);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<WelcomeBean>() {
                    @Override
                    public void call(WelcomeBean welcomeBean) {
                        mView.showContent(welcomeBean);
                        startCountDown();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                        Log.e("qmyan", "error");
                        mView.jumpToMain();
                    }
                });
    }

    private void startCountDown() {
        Observable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {

                    @Override
                    public void call(Long aLong) {
                        mView.jumpToMain();
                    }
                });
    }

    @Override
    public void attachView(WelcomeContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
