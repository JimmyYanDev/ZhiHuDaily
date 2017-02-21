package com.micheal_yan.zhihudaily.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.micheal_yan.zhihudaily.R;
import com.micheal_yan.zhihudaily.base.BaseActivity;
import com.micheal_yan.zhihudaily.model.bean.WelcomeBean;
import com.micheal_yan.zhihudaily.presenter.WelcomePresenter;
import com.micheal_yan.zhihudaily.presenter.contract.WelcomeContract;

import butterknife.BindView;

/**
 * Created by micheal-yan on 2017/2/19.
 */
public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View {

    @BindView(R.id.iv_welcome_image)
    ImageView mImageView;
    @BindView(R.id.tv_welcome_text)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initEventAndData() {
        mPresenter = new WelcomePresenter();
        mPresenter.getWelcomeData();
    }

    @Override
    protected void onDestroy() {
        Glide.clear(mImageView);
        super.onDestroy();
    }

    @Override
    public void showContent(WelcomeBean welcomeBean) {
        mTextView.setText(welcomeBean.getWho());
        Glide.with(mContext).load(welcomeBean.getImgUrl()).centerCrop().into(mImageView);
        mImageView.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();
    }

    @Override
    public void jumpToMain() {
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void showError(String msg) {
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }
}
