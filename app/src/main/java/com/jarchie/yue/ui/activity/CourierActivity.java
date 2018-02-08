package com.jarchie.yue.ui.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.jarchie.common.base.BaseActivity;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.common.widget.LoadingTip;
import com.jarchie.yue.R;
import com.jarchie.yue.api.Api;
import com.jarchie.yue.bean.CourierBean;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.constant.HostType;
import com.jarchie.yue.ui.adapter.KuaidiListAdapter;
import com.jarchie.yue.ui.widget.CustomToolBar;
import com.jarchie.yue.ui.widget.SpinnerPopWindow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import butterknife.Bind;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jarchie on 2018\2\7.
 * 物流查询模块
 */
public class CourierActivity extends BaseActivity {
    @Bind(R.id.mToolbar)
    CustomToolBar mToolbar;
    @Bind(R.id.mSpinnerText)
    TextView mSpinnerText;
    @Bind(R.id.mEdit)
    EditText mEdit;
    @Bind(R.id.mBtnQuery)
    TextView mBtnQuery;
    @Bind(R.id.kuaidi_list)
    RecyclerView kuaidiList;
    @Bind(R.id.mSpinnerLayout)
    LinearLayout mSpinnerLayout;
    @Bind(R.id.loadedTip)
    LoadingTip loadedTip;
    private SpinnerPopWindow<String> mSpinerPopWindow;

    private List<String> mComList;
    private List<String> mNumList;
    private String numString = "";
    private List<CourierBean.ResultBean.ListBean> mList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_courier;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void initListener() {
        mToolbar.setLeftBtnListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CourierActivity.this.finish();
            }
        });
    }

    @Override
    public void initData() {
        mToolbar.setTitle("快递查询");
        setupPopViews();
    }

    @OnClick({R.id.mSpinnerText, R.id.mBtnQuery})
    public void onClick(TextView view) {
        switch (view.getId()) {
            case R.id.mSpinnerText:
                mSpinerPopWindow.setWidth(mSpinnerLayout.getWidth());
                mSpinerPopWindow.showAsDropDown(mSpinnerLayout);
                break;
            case R.id.mBtnQuery:
                requestData();
                break;
        }
    }

    //查询快递数据
    private void requestData() {
        if (!mSpinnerText.getText().toString().equals("请选择快递公司") && !TextUtils.isEmpty(mEdit.getText().toString())) {
            showLoading("");
            Map<String, Object> map = new HashMap<>();
            map.put("com", numString);
            map.put("no", mEdit.getText().toString());
            map.put("key", Constant.COURIER_KEY);
            Api.getDefault(HostType.KUAIDI_HOST).requestCourierData(map).enqueue(new Callback<CourierBean>() {
                @SuppressWarnings("ConstantConditions")
                @Override
                public void onResponse(@NonNull Call<CourierBean> call, @NonNull Response<CourierBean> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getResultcode().equals("200")) {
                            stopLoading();
                            if (response.body().getResult() != null) {
                                if (response.body().getResult().getList().size() > 0) {
                                    mList.addAll(response.body().getResult().getList());
                                    Collections.reverse(mList);
                                    kuaidiList.setLayoutManager(new LinearLayoutManager(CourierActivity.this));
                                    kuaidiList.setItemAnimator(new DefaultItemAnimator());
                                    KuaidiListAdapter mAdapter = new KuaidiListAdapter(CourierActivity.this, mList);
                                    kuaidiList.setAdapter(mAdapter);
                                }
                            }
                        } else {
                            showErrorTip("数据加载失败");
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<CourierBean> call, @NonNull Throwable t) {
                    SmartToast.showInCenter(t.getMessage());
                    showErrorTip(t.getMessage());
                }
            });
        } else {
            SmartToast.showInCenter("请将公司名称和快递号填写完整");
        }
    }

    @SuppressWarnings("unchecked")
    private void setupPopViews() {
        mComList = Arrays.asList(getResources().getStringArray(R.array.kuaidi_list));
        mNumList = Arrays.asList(getResources().getStringArray(R.array.kuaidi_num_list));
        mSpinerPopWindow = new SpinnerPopWindow<>(this, mComList, spItemListener);
        mSpinerPopWindow.setOnDismissListener(spDisListener);
    }

    //下拉列表每一项点击事件
    private AdapterView.OnItemClickListener spItemListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            mSpinnerText.setText(mComList.get(position));
            numString = mNumList.get(position);
            mSpinerPopWindow.dismiss();
        }
    };

    //下拉列表取消监听
    private PopupWindow.OnDismissListener spDisListener = new PopupWindow.OnDismissListener() {
        @Override
        public void onDismiss() {
            mSpinerPopWindow.dismiss();
        }
    };

    @Override
    public void showLoading(String title) {
        kuaidiList.setVisibility(View.GONE);
        loadedTip.setVisibility(View.VISIBLE);
        loadedTip.setLoadingTip(LoadingTip.LoadStatus.loading);
    }

    @Override
    public void stopLoading() {
        kuaidiList.setVisibility(View.VISIBLE);
        loadedTip.setVisibility(View.GONE);
        loadedTip.setLoadingTip(LoadingTip.LoadStatus.finish);
    }

    @Override
    public void showErrorTip(String msg) {
        kuaidiList.setVisibility(View.GONE);
        loadedTip.setVisibility(View.VISIBLE);
        loadedTip.setLoadingTip(LoadingTip.LoadStatus.error);
    }

}
