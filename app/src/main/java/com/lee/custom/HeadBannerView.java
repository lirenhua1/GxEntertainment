package com.lee.custom;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;


import com.lee.activity.R;
import com.lee.adapter.BannerPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2015/11/23 0023.
 */
public class HeadBannerView extends FrameLayout implements ViewPager.OnPageChangeListener {

    private MyViewPager viewPager;
    private ImgNavView inv;
    private BannerPagerAdapter adapter;

    public HeadBannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.custom_banner_layout, this, true);
        viewPager = (MyViewPager) findViewById(R.id.vp_banner);
        adapter = new BannerPagerAdapter();

        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);

        inv = (ImgNavView) findViewById(R.id.img_nav);
    }

    public void setDatas(List<ImageView> datas){
        adapter.setDatas(datas);
        inv.setCount(datas.size());
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        inv.selectIndex(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
