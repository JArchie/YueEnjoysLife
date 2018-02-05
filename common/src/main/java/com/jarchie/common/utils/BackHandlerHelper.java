package com.jarchie.common.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by Jarchie on 2017\11\21.
 * 描述：将back事件分发给 FragmentManager 中管理的子Fragment，如果该 FragmentManager 中的所有Fragment都
 * 没有处理back事件，则尝试 FragmentManager.popBackStack()
 *
 * 如果处理了back键则返回 true
 * handleBackPress(Fragment)
 * handleBackPress(FragmentActivity)
 * handleBackPress(AppCompatActivity)
 * handleBackPress(ViewPager)
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public class BackHandlerHelper {
    public static boolean handleBackPress(FragmentManager fragmentManager) {
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments == null) return false;
        for (int i = fragments.size() - 1; i >= 0; i--) {
            Fragment child = fragments.get(i);
            if (isFragmentBackHandled(child)) {
                return true;
            }
        }

        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
            return true;
        }
        return false;
    }

    public static boolean handleBackPress(Fragment fragment) {
        return handleBackPress(fragment.getChildFragmentManager());
    }

    public static boolean handleBackPress(FragmentActivity fragmentActivity) {
        return handleBackPress(fragmentActivity.getSupportFragmentManager());
    }

    public static boolean handleBackPress(AppCompatActivity appCompatActivity){
        return handleBackPress(appCompatActivity.getSupportFragmentManager());
    }

    //将back事件分发给ViewPager中的Fragment
    public static boolean handleBackPress(ViewPager viewPager) {
        if (viewPager == null) return false;

        PagerAdapter adapter = viewPager.getAdapter();

        if (adapter == null) return false;

        int currentItem = viewPager.getCurrentItem();
        Fragment fragment;
        if (adapter instanceof FragmentPagerAdapter) {
            fragment = ((FragmentPagerAdapter) adapter).getItem(currentItem);
        } else if (adapter instanceof FragmentStatePagerAdapter) {
            fragment = ((FragmentStatePagerAdapter) adapter).getItem(currentItem);
        } else {
            fragment = null;
        }
        return isFragmentBackHandled(fragment);
    }

    /**
     * 判断Fragment是否处理了Back键
     *
     * @return 如果处理了back键则返回 <b>true</b>
     */
    public static boolean isFragmentBackHandled(Fragment fragment) {
        return fragment != null
                && fragment.isVisible()
                && fragment.getUserVisibleHint() //for ViewPager
                && fragment instanceof FragmentBackHandler
                && ((FragmentBackHandler) fragment).onBackPressed();
    }

}
