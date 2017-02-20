package com.micheal_yan.zhihudaily.ui.welcome;

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
import com.micheal_yan.zhihudaily.ui.main.activity.MainActivity;

import butterknife.BindView;

/**
 * Created by micheal-yan on 2017/2/19.
 */
public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View{

    @BindView(R.id.iv_welcome_image)
    private ImageView mImageView;
    @BindView(R.id.tv_welcome_text)
    private TextView mTextView;

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
        super.onDestroy();
        Glide.get(this).clearMemory();
    }

    @Override
    public void showContent(WelcomeBean welcomeBean) {
        Glide.with(this).load(welcomeBean.getImgUrl()).error(R.drawable.panda).thumbnail(0.1f).crossFade().fitCenter().into(mImageView);
        mTextView.setText(welcomeBean.getWho());
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
