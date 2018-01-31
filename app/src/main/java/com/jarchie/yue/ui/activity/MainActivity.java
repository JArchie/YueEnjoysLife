package com.jarchie.yue.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.coder.zzq.smartshow.toast.SmartToast;
import com.jarchie.common.utils.ActivityManager;
import com.jarchie.yue.R;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.ui.fragment.GirlFragment;
import com.jarchie.yue.ui.fragment.AssistantFragment;
import com.jarchie.yue.ui.fragment.NewsFragment;
import com.jarchie.yue.ui.fragment.VideoFragment;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;
import com.luseen.luseenbottomnavigation.BottomNavigation.OnBottomNavigationItemClickListener;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Jarchie on 2018\1\24.
 * 项目主页Activity
 */
public class MainActivity extends AppCompatActivity implements OnBottomNavigationItemClickListener {

    @Bind(R.id.navigation_view)
    BottomNavigationView mNavigationView;
    private Fragment newsFragment, girlFragment, videoFragment, assistantFragment;
    private static long exitTime = 0; //退出APP的时间

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initListener();
        initData();
    }

    public void initListener() {
        mNavigationView.setOnBottomNavigationItemClickListener(this);
    }

    public void initData() {
        initNavigationView();
        mNavigationView.selectTab(0);
        setSelect(0);
    }

    @Override
    public void onNavigationItemClick(int index) {
        switch (index) {
            case 0:
                setSelect(0);
                break;
            case 1:
                setSelect(1);
                break;
            case 2:
                setSelect(2);
                break;
            case 3:
                setSelect(3);
                break;
        }
    }

    //初始化BottomNavagationView
    private void initNavigationView() {
        if (mNavigationView != null) {
            mNavigationView.isWithText(true); //设置汉字一直显示
            //整体背景色，false是icon和文字显示颜色能用，此时是默认的颜色
            mNavigationView.isColoredBackground(false);
            mNavigationView.setItemActiveColorWithoutColoredBackground(ContextCompat.getColor(this, R.color.color_main));
        }
        BottomNavigationItem newsItem = new BottomNavigationItem(getString(R.string.tab_news), ContextCompat.getColor(this, R.color.color_main), R.drawable.tab_news);
        BottomNavigationItem girlItem = new BottomNavigationItem(getString(R.string.tab_girl), ContextCompat.getColor(this, R.color.color_main), R.drawable.tab_girl);
        BottomNavigationItem videoItem = new BottomNavigationItem(getString(R.string.tab_video), ContextCompat.getColor(this, R.color.color_main), R.drawable.tab_video);
        BottomNavigationItem mineItem = new BottomNavigationItem(getString(R.string.tab_assistant), ContextCompat.getColor(this, R.color.color_main), R.drawable.tab_assistant);
        mNavigationView.addTab(newsItem);
        mNavigationView.addTab(girlItem);
        mNavigationView.addTab(videoItem);
        mNavigationView.addTab(mineItem);
    }

    //控制切换显示四个Fragment
    private void setSelect(int pos) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        switch (pos) {
            case 0: //新闻模块
                if (newsFragment == null) {
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.id_content, newsFragment);
                } else {
                    transaction.show(newsFragment);
                }
                break;
            case 1: //妹子模块
                if (girlFragment == null) {
                    girlFragment = new GirlFragment();
                    transaction.add(R.id.id_content, girlFragment);
                } else {
                    transaction.show(girlFragment);
                }
                break;
            case 2: //视频模块
                if (videoFragment == null) {
                    videoFragment = new VideoFragment();
                    transaction.add(R.id.id_content, videoFragment);
                } else {
                    transaction.show(videoFragment);
                }
                break;
            case 3: //助手模块
                if (assistantFragment == null) {
                    assistantFragment = new AssistantFragment();
                    transaction.add(R.id.id_content, assistantFragment);
                } else {
                    transaction.show(assistantFragment);
                }
                break;
        }
        transaction.commit();
    }

    //隐藏Fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (newsFragment != null) {
            transaction.hide(newsFragment);
        }
        if (girlFragment != null) {
            transaction.hide(girlFragment);
        }
        if (videoFragment != null) {
            transaction.hide(videoFragment);
        }
        if (assistantFragment != null) {
            transaction.hide(assistantFragment);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > Constant.EXIT_TIME) {
                SmartToast.show("再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                ActivityManager.getInstance().finishAllActivity();
                //结束进程
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
                if (exitTime != 0) {
                    exitTime = 0;
                }
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        ActivityManager.getInstance().removeActivity(this);
    }

}