package com.micheal_yan.zhihudaily.model.http;

import com.micheal_yan.zhihudaily.model.bean.DailyListBean;
import com.micheal_yan.zhihudaily.model.bean.ZhihuDetailBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by micheal-yan on 2017/2/25.
 */

public interface ZhiHuApis {

    String HOST = "http://news-at.zhihu.com/api/4/";

    @GET("news/latest")
    Observable<DailyListBean> getDailyList();

    /**
     * 日报详情
     */
    @GET("news/{id}")
    Observable<ZhihuDetailBean> getDetailInfo(@Path("id") int id);
}
