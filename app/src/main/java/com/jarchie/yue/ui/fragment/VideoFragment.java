package com.jarchie.yue.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jarchie.yue.R;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.ui.adapter.VideoPagerAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jarchie on 2018\1\24.
 * 视频Fragment
 */

public class VideoFragment extends Fragment implements ViewPager.OnPageChangeListener {

    @Bind(R.id.mTabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.mViewPager)
    ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.fragment_video_layout, container, false);
        ButterKnife.bind(this, mRootView);
        initListener();
        initData();
        return mRootView;
    }

    public void initListener() {
        mViewPager.addOnPageChangeListener(this);
    }

    public void initData() {
        List<String> titles = Arrays.asList(getContext().getResources().getStringArray(R.array.video_type_name));
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(VideoListFragment.newInstance(Constant.VIDEO_RD));
        fragments.add(VideoListFragment.newInstance(Constant.VIDEO_YL));
        fragments.add(VideoListFragment.newInstance(Constant.VIDEO_GX));
        fragments.add(VideoListFragment.newInstance(Constant.VIDEO_JP));
        VideoPagerAdapter mAdapter = new VideoPagerAdapter(getChildFragmentManager());
        mAdapter.setFragments(titles, fragments);
        mViewPager.setCurrentItem(0);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
