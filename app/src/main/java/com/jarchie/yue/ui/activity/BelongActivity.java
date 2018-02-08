package com.jarchie.yue.ui.activity;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.jarchie.common.base.BaseActivity;
import com.jarchie.common.base.BasePresenter;
import com.jarchie.yue.R;
import com.jarchie.yue.api.Api;
import com.jarchie.yue.bean.BelongBean;
import com.jarchie.yue.constant.Constant;
import com.jarchie.yue.constant.HostType;
import com.jarchie.yue.ui.widget.CustomToolBar;
import butterknife.Bind;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jarchie on 2018\2\7.
 * 归属地查询
 */
public class BelongActivity extends BaseActivity {
    @Bind(R.id.mToolbar)
    CustomToolBar mToolbar;
    @Bind(R.id.et_number)
    EditText etNumber;
    @Bind(R.id.iv_company)
    ImageView ivCompany;
    @Bind(R.id.tv_result)
    TextView tvResult;
    @Bind(R.id.btn_1)
    Button btn1;
    @Bind(R.id.btn_2)
    Button btn2;
    @Bind(R.id.btn_3)
    Button btn3;
    @Bind(R.id.btn_del)
    Button btnDel;
    @Bind(R.id.btn_4)
    Button btn4;
    @Bind(R.id.btn_5)
    Button btn5;
    @Bind(R.id.btn_6)
    Button btn6;
    @Bind(R.id.btn_0)
    Button btn0;
    @Bind(R.id.btn_7)
    Button btn7;
    @Bind(R.id.btn_8)
    Button btn8;
    @Bind(R.id.btn_9)
    Button btn9;
    @Bind(R.id.btn_select)
    Button btnSelect;
    private String str;
    private boolean flag = false; //标记位

    @Override
    public int getLayoutId() {
        return R.layout.activity_belong;
    }

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void initListener() {
        btnDel.setOnLongClickListener(new View.OnLongClickListener() { //长按清除
            @Override
            public boolean onLongClick(View view) {
                etNumber.setText("");
                return false;
            }
        });
    }

    @Override
    public void initData() {
        mToolbar.setTitle("归属地查询");
        mToolbar.setLeftBtnListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BelongActivity.this.finish();
            }
        });
        ivCompany.setVisibility(View.GONE);
        tvResult.setText("欢迎查询您的归属地");
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_0,
            R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_del, R.id.btn_select})
    public void onClick(Button button) {
        //获取输入框中的内容
        str = etNumber.getText().toString();
        switch (button.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
                if (flag) {
                    flag = false;
                    str = "";
                    etNumber.setText("");
                }
                //每次结尾加1
                etNumber.setText(str + (button.getText().toString()));
                etNumber.setSelection(str.length() + 1);
                break;
            case R.id.btn_del:
                if (!TextUtils.isEmpty(str) && str.length() > 0) {
                    //每次结尾减去1
                    etNumber.setText(str.substring(0, str.length() - 1));
                    etNumber.setSelection(str.length() - 1);
                }
                break;
            case R.id.btn_select:
                if (!TextUtils.isEmpty(str)) {
                    queryData();
                }
                break;
        }
    }

    //请求数据
    private void queryData() {
        Api.getDefault(HostType.JUHE_HOST).requestBelongData(str, Constant.BELONG_KEY).enqueue(new Callback<BelongBean>() {
            @SuppressWarnings("ConstantConditions")
            @Override
            public void onResponse(@NonNull Call<BelongBean> call, @NonNull Response<BelongBean> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getResult() != null) {
                            BelongBean.ResultBean bean = response.body().getResult();
                            tvResult.setText("归属地:" + bean.getProvince() + bean.getCity() + "\n" +
                                    "区号:" + bean.getAreacode() + "\n" + "邮编:" + bean.getZip() + "\n" +
                                    "运营商:" + bean.getCompany());
                            //图片显示
                            ivCompany.setVisibility(View.VISIBLE);
                            switch (bean.getCompany()) {
                                case "移动":
                                    ivCompany.setImageResource(R.drawable.china_moblie);
                                    break;
                                case "联通":
                                    ivCompany.setImageResource(R.drawable.china_ubicom);
                                    break;
                                case "电信":
                                    ivCompany.setImageResource(R.drawable.china_telecom);
                                    break;
                            }
                            flag = true;
                        } else {
                            SmartToast.showInCenter("对不起，暂无相应数据");
                        }
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<BelongBean> call, @NonNull Throwable t) {
                SmartToast.showInCenter(t.getMessage());
            }
        });
    }

    @Override
    public void showLoading(String title) {}
    @Override
    public void stopLoading() {}
    @Override
    public void showErrorTip(String msg) {}
}
