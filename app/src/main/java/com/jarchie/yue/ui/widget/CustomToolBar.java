package com.jarchie.yue.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jarchie.yue.R;

/**
 * Created by Jarchie on 2018\2\5.
 * 重新自定义Toolbar
 */

@SuppressWarnings("DanglingJavadoc")
public class CustomToolBar extends Toolbar {
    private View mView;
    private ImageView mBtnBack;
    private TextView mTitle;
    private ImageView mBtnSearch;

    //构造方法
    public CustomToolBar(Context context) {
        this(context, null);
    }

    public CustomToolBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 下面是摘自官方文档
         * final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
         R.styleable.Toolbar, defStyleAttr, 0);

         mTitleTextAppearance = a.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
         mSubtitleTextAppearance = a.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
         mGravity = a.getInteger(R.styleable.Toolbar_android_gravity, mGravity);
         mButtonGravity = Gravity.TOP;
         mTitleMarginStart = mTitleMarginEnd = mTitleMarginTop = mTitleMarginBottom =
         a.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, 0);

         final int marginStart = a.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
         if (marginStart >= 0) {
         mTitleMarginStart = marginStart;
         }
         */
        initView();
        setContentInsetsRelative(10, 10);
        if (attrs != null) {
            //读写自定义的属性
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs, R.styleable.CustomToolBar, defStyleAttr, 0);
            final Drawable leftIcon = a.getDrawable(R.styleable.CustomToolBar_leftButtonIcon);
            if (leftIcon != null) {
                setLeftBtnIcon(leftIcon);
            }
            final Drawable rightIcon = a.getDrawable(R.styleable.CustomToolBar_rightButtonIcon);
            if (rightIcon != null) {
                setRightBtnIcon(rightIcon);
            }
            boolean isShowSearch = a.getBoolean(R.styleable.CustomToolBar_isShowSearchView, false);
            //如果要显示SearchView的时候
            if (isShowSearch) {
                showSearch();
            }
            a.recycle(); //资源回收
        }
    }

    private void initView() {
        if (mView == null) {
            LayoutInflater mInflater = LayoutInflater.from(getContext());
            mView = mInflater.inflate(R.layout.common_title_bar, null);
            mBtnBack = mView.findViewById(R.id.topbar_back);
            mTitle = mView.findViewById(R.id.topbar_title);
            mBtnSearch = mView.findViewById(R.id.topbar_search);
            //把控件添加到子View中
            ViewGroup.LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
            addView(mView, lp);
        }
    }

    @Override
    public void setTitle(@StringRes int resId) {
        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        initView();
        if (mTitle != null) {
            mTitle.setText(title);
            showTitle();
        }
    }

    //隐藏标题
    public void hideTitle() {
        if (mTitle != null)
            mTitle.setVisibility(GONE);
    }

    //显示标题
    public void showTitle() {
        if (mTitle != null)
            mTitle.setVisibility(VISIBLE);
    }

    //隐藏搜索框
    public void hideSearch() {
        if (mBtnSearch != null)
            mBtnSearch.setVisibility(GONE);
    }

    //显示搜索框
    public void showSearch() {
        if (mBtnSearch != null)
            mBtnSearch.setVisibility(VISIBLE);
    }

    //隐藏返回按钮
    public void hideBack() {
        if (mBtnBack != null)
            mBtnBack.setVisibility(GONE);
    }

    //显示返回按钮
    public void showBack() {
        if (mBtnBack != null)
            mBtnBack.setVisibility(VISIBLE);
    }

    //给左侧按钮设置图片
    public void setLeftBtnIcon(Drawable icon) {
        if (mBtnBack != null) {
            mBtnBack.setImageDrawable(icon);
            mBtnBack.setVisibility(VISIBLE);
        }
    }

    //给右侧按钮设置图片
    public void setRightBtnIcon(Drawable icon) {
        if (mBtnSearch != null) {
            mBtnSearch.setImageDrawable(icon);
            mBtnSearch.setVisibility(VISIBLE);
        }
    }

    //设置左侧按钮的监听事件
    public void setLeftBtnListener(OnClickListener listener) {
        mBtnBack.setOnClickListener(listener);
    }

    //设置右侧按钮的监听事件
    public void setRightBrnListener(OnClickListener listener) {
        mBtnSearch.setOnClickListener(listener);
    }

}
