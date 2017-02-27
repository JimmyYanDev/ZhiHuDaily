package com.micheal_yan.zhihudaily.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.MimeTypeMap;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.micheal_yan.zhihudaily.R;
import com.micheal_yan.zhihudaily.model.bean.DailyListBean;
import com.micheal_yan.zhihudaily.model.bean.ZhihuDetailBean;
import com.micheal_yan.zhihudaily.model.http.ZhiHuApis;
import com.micheal_yan.zhihudaily.util.HtmlUtil;
import com.micheal_yan.zhihudaily.util.SnackbarUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by micheal-yan on 2017/2/27.
 */

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.wv_detail)
    WebView mWebView;

    private ZhiHuApis zhiHUService;
    private Retrofit mRetrofit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);  //支持js
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        Intent intent = getIntent();
        int id = intent.getExtras().getInt("id");
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ZhiHuApis.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        zhiHUService = mRetrofit.create(ZhiHuApis.class);
        Observable<ZhihuDetailBean> observable = zhiHUService.getDetailInfo(id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<ZhihuDetailBean, String>() {
                    @Override
                    public String call(ZhihuDetailBean bean) {
                        return HtmlUtil.createHtmlData(bean.getBody(), bean.getCss(), bean.getJs());
                    }

                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String htmlData) {
                        mWebView.loadData(htmlData, HtmlUtil.MIME_TYPE, HtmlUtil.ENCODING);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        SnackbarUtil.show(mWebView, "数据加载失败ヽ(≧Д≦)ノ");
                    }
                });

    }
}
