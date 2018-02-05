package com.jarchie.yue.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.jarchie.common.base.BaseFragment;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.yue.R;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.ui.adapter.NewsPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Jarchie on 2018\1\24.
 * 新闻Fragment
 */

public class NewsFragment extends BaseFragment implements ViewPager.OnPageChangeListener {

    @Bind(R.id.mTabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.mViewPager)
    ViewPager mViewPager;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news_layout;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void initListener() {
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void initData() {
        List<String> titles = Arrays.asList(getContext().getResources().getStringArray(R.array.news_channel_name));
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(NewsListFragment.newInstance(Constant.TOUTIAO));
        fragments.add(NewsListFragment.newInstance(Constant.XINWEN));
        fragments.add(NewsListFragment.newInstance(Constant.CAIJING));
        fragments.add(NewsListFragment.newInstance(Constant.TIYU));
        fragments.add(NewsListFragment.newInstance(Constant.YULE));
        fragments.add(NewsListFragment.newInstance(Constant.JIAOYU));
        fragments.add(NewsListFragment.newInstance(Constant.KEJI));
        fragments.add(NewsListFragment.newInstance(Constant.JIANKANG));
        NewsPagerAdapter mAdapter = new NewsPagerAdapter(getChildFragmentManager());
        mAdapter.setFragments(titles, fragments);
        mViewPager.setCurrentItem(0);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
    @Override
    public void onPageSelected(int position) {}
    @Override
    public void onPageScrollStateChanged(int state) {}

    @Override
    public void showLoading(String title) {}
    @Override
    public void stopLoading() {}
    @Override
    public void showErrorTip(String msg) {}
}
