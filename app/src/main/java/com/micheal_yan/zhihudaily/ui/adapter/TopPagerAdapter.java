package com.micheal_yan.zhihudaily.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.micheal_yan.zhihudaily.R;
import com.micheal_yan.zhihudaily.model.bean.DailyListBean;
import com.micheal_yan.zhihudaily.ui.activity.DetailActivity;
import com.micheal_yan.zhihudaily.util.SnackbarUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by codeest on 16/8/13.
 */

public class TopPagerAdapter extends PagerAdapter {

    private List<DailyListBean.TopStoriesBean> mList = new ArrayList<>();
    private Context mContext;

    public TopPagerAdapter(Context context, List<DailyListBean.TopStoriesBean> mList) {
        this.mList = mList;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_top_pager, container, false);
        ImageView ivImage = (ImageView) view.findViewById(R.id.iv_top_image);
        TextView tvTitle = (TextView) view.findViewById(R.id.tv_top_title);
        Glide.with(mContext).load(mList.get(position).getImage()).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(ivImage);
        tvTitle.setText(mList.get(position).getTitle());
        final int id = mList.get(position).getId();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SnackbarUtil.show(container, "打开详情页面");
                Intent intent = new Intent();
                intent.setClass(mContext, DetailActivity.class);
                intent.putExtra("id", id);
                mContext.startActivity(intent);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
