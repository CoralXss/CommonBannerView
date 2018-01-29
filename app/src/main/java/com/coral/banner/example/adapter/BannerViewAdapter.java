package com.coral.banner.example.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.coral.banner.BannerPagerAdapter;
import com.coral.banner.example.R;
import com.makeramen.roundedimageview.RoundedImageView;

/**
 * Created by xss on 2018/1/26.
 */

public class BannerViewAdapter extends BannerPagerAdapter<String> {

    @Override
    public BannerViewHolder createViewHolder(ViewGroup container) {
        return new BannerViewHolder();
    }

    public static class BannerViewHolder implements BannerPagerAdapter.BaseBannerViewHolder<String> {

        private RoundedImageView mImageView;
        private TextView mTvMsg;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.adapter_banner_item_view, null);

            mImageView = view.findViewById(R.id.ivBanner);
            mTvMsg = view.findViewById(R.id.tvMsg);


            return view;
        }

        @Override
        public void bind(Context context, String data, int position) {
//            if (!TextUtils.isEmpty(data)) {
//                Glide.with(context).load(data).placeholder(R.drawable.ic_launcher_background).into(mImageView);
//            }
            mTvMsg.setText(position + "");
            mImageView.setImageResource(R.drawable.ic_launcher_background);
        }
    }

}
