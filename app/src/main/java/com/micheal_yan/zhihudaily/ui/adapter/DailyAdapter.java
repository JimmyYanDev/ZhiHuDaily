package com.micheal_yan.zhihudaily.ui.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.micheal_yan.zhihudaily.R;
import com.micheal_yan.zhihudaily.model.bean.DailyListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by micheal-yan on 2017/2/25.
 */

public class DailyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<DailyListBean.StoriesBean> mList = new ArrayList<>();
    private List<DailyListBean.TopStoriesBean> mTopList = new ArrayList<>();
    private LayoutInflater inflater;
    private TopPagerAdapter mAdapter;
    private ViewPager topViewPager;
    private OnItemClickListener onItemClickListener;
    private Context mContext;
    private String currentTitle = "今日热闻";

    public enum ITEM_TYPE {
        ITEM_TOP,   // 滚动栏
        ITEM_DATE,   // 日期
        ITEM_CONTENT   // 内容
    }

    public DailyAdapter() {
    }

    public DailyAdapter(List<DailyListBean.StoriesBean> list, List<DailyListBean.TopStoriesBean> topList) {
        this.mList = list;
        mTopList = topList;
    }

    /**
     * 根据不同的位置返回不同的布局类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            // 如果是第一个子布局返回类型为滚动栏
            return ITEM_TYPE.ITEM_TOP.ordinal();
        } else if (position == 1) {
            return ITEM_TYPE.ITEM_DATE.ordinal();
        } else {
            return ITEM_TYPE.ITEM_CONTENT.ordinal();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        inflater = LayoutInflater.from(mContext);
        if (viewType == ITEM_TYPE.ITEM_CONTENT.ordinal()) {
            return new ContentViewHolder(inflater.inflate(R.layout.item_daily, parent, false));
        } else if (viewType == ITEM_TYPE.ITEM_DATE.ordinal()) {
            return new DateViewHolder(inflater.inflate(R.layout.item_date, parent, false));
        } else if (viewType == ITEM_TYPE.ITEM_TOP.ordinal()) {
            mAdapter = new TopPagerAdapter(mContext, mTopList);
            return new TopViewHolder(inflater.inflate(R.layout.item_top, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ContentViewHolder) {
            final int contentPosition;
            contentPosition = position - 2;
            ((ContentViewHolder) holder).mTextView.setText(mList.get(contentPosition).getTitle());
            Glide.with(mContext).load(mList.get(position).getImages().get(0)).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(((ContentViewHolder) holder).mImageView);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        ImageView iv = (ImageView) view.findViewById(R.id.iv_daily_item_image);
                        onItemClickListener.onItemClick(contentPosition, iv);
                    }
                }
            });
        } else if (holder instanceof DateViewHolder) {
            ((DateViewHolder) holder).tvDate.setText(currentTitle);
        } else {
            ((TopViewHolder) holder).vpTop.setAdapter(mAdapter);
            topViewPager = ((TopViewHolder) holder).vpTop;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addDailyDate(DailyListBean info) {
        currentTitle = "今日热闻";
        mList = info.getStories();
        mTopList = info.getTop_stories();
        notifyDataSetChanged();
    }

    public static class ContentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_daily_item_image)
        ImageView mImageView;
        @BindView(R.id.tv_daily_item_title)
        TextView mTextView;

        public ContentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class DateViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_daily_date)
        TextView tvDate;

        public DateViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class TopViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.vp_top)
        ViewPager vpTop;
        @BindView(R.id.ll_point_container)
        LinearLayout llContainer;

        public TopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position, View view);
    }
}
