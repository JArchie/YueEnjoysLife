package com.jarchie.yue.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.jarchie.common.base.BaseFragment;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.common.utils.BackHandlerHelper;
import com.jarchie.yue.R;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.ui.adapter.VideoPagerAdapter;
import com.jarchie.yue.ui.widget.CustomToolBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Jarchie on 2018\1\24.
 * 视频Fragment https://github.com/jokermonn/-Api/blob/master/Neihan.md#video_show
 */

public class VideoFragment extends BaseFragment implements ViewPager.OnPageChangeListener {

    @Bind(R.id.mTabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.mViewPager)
    ViewPager mViewPager;
    @Bind(R.id.mToolbar)
    CustomToolBar mToolbar;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_video_layout;
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
        mToolbar.hideBack();
        mToolbar.setTitle("内涵段子");
        List<String> titles = Arrays.asList(getContext().getResources().getStringArray(R.array.video_type_name));
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(VideoListFragment.newInstance(Constant.VIDEO_TJ));
        fragments.add(VideoListFragment.newInstance(Constant.VIDEO_SP));
        fragments.add(new JokesFragment());
        VideoPagerAdapter mAdapter = new VideoPagerAdapter(getChildFragmentManager());
        mAdapter.setFragments(titles, fragments);
        mViewPager.setCurrentItem(0);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onBackPressed() {
        return BackHandlerHelper.handleBackPress(this);
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

    @Override
    public void showLoading(String title) {
    }

    @Override
    public void stopLoading() {
    }

    @Override
    public void showErrorTip(String msg) {
    }
}
