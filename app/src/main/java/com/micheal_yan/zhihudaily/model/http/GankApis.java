package com.micheal_yan.zhihudaily.model.http;

import com.micheal_yan.zhihudaily.model.bean.GankItemBean;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by micheal-yan on 2017/2/19.
 */

public interface GankApis {

    String HOST = "http://gank.io/api/";

    @GET("data/福利/1/1")
    Observable<List<GankItemBean>> getWelcomeData();
}
