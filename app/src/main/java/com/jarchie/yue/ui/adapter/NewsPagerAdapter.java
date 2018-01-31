package com.jarchie.yue.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jarchie on 2018\1\29.
 * 新闻模块的页面适配器,用来适配ViewPager
 * 当页面较多时，为了节省内存应该使用FragmentStatePagerAdapter
 */

public class NewsPagerAdapter extends FragmentStatePagerAdapter {
    private List<String> mTitles;
    private List<Fragment> mFragments;

    public void setFragments(List<String> titles, List<Fragment> fragments) {
        if (titles == null) {
            mTitles = new ArrayList<>();
        } else
            mTitles = titles;
        if (fragments == null) {
            mFragments = new ArrayList<>();
        } else
            mFragments = fragments;
    }

    public NewsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
