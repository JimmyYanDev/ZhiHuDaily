package com.micheal_yan.zhihudaily.presenter;

import com.micheal_yan.zhihudaily.model.bean.GankItemBean;
import com.micheal_yan.zhihudaily.model.http.GankApis;
import com.micheal_yan.zhihudaily.presenter.contract.WelcomeContract;

import org.reactivestreams.Subscriber;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by micheal-yan on 2017/2/19.
 */

public class WelcomePresenter implements WelcomeContract.Presenter {

    private Retrofit mRetrofit;

    @Override
    public void start() {

        mRetrofit = new Retrofit.Builder()
                .baseUrl(GankApis.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


    private GankApis service = mRetrofit.create(GankApis.class);

    @Override
    public void getWelcomeData() {
        Subscriber<List<GankItemBean>> subscriber = (Subscriber<List<GankItemBean>>) service.getWelcomeData();
    }
}
