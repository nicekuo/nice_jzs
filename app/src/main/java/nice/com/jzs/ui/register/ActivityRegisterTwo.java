package nice.com.jzs.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nice.com.jzs.R;
import nice.com.jzs.background.RequestAPI;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.ui.ViewProgress;
import nice.com.nice_library.bean.BaseBean;
import nice.com.nice_library.util.ToastUtil;


/**
 * Created by BaoLongxiang on 2016/2/18.
 * 登陆
 */
@EActivity(R.layout.activity_register_two)
public class ActivityRegisterTwo extends AbstractActivity {

    @ViewById(R.id.id_btn_code)
    TextView idBtnCode;
    @ViewById(R.id.id_ev_code)
    EditText idEvCode;
    @ViewById(R.id.id_btn_login)
    TextView idBtnLogin;

    @ViewById(R.id.view_progress)
    ViewProgress view_progress;

    private CountDownTimer mCountDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
            mCountDownTimer = null;
        }
    }

    @AfterViews
    void initView() {


        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.icon_select_true);
        images.add(R.drawable.icon_circle_true);
        images.add(R.drawable.icon_circle_false);
        images.add(R.drawable.icon_circle_false);
        images.add(R.drawable.icon_circle_false);
        images.add(R.drawable.icon_circle_false);
        view_progress.setImages(images);

        titleView.mTitle.setText("手机验证码");
        mCountDownTimer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String string = String.format(getString(R.string.authcode_shengyu), millisUntilFinished / 1000);
                idBtnCode.setText(string);
            }

            @Override
            public void onFinish() {
                countDownFinish();
            }
        };


    }

    private void countDownFinish() {
        idBtnCode.setEnabled(true);
        idBtnCode.setText(getString(R.string.get_authcode));
    }

    private void setUnable() {
        idBtnCode.setEnabled(false);
        if (mCountDownTimer != null) {
            mCountDownTimer.start();
        }
    }


    @Click({R.id.id_btn_login, R.id.id_txv_login_type_switch, R.id.id_btn_code})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_btn_code://获取验证码按钮
//                String phoneStr = idEvPhone.getText().toString();
//                if (TextUtils.isEmpty(idEvPhone.getText().toString())) {
//                    ToastUtil.showToastMessage(ActivityRegisterTwo.this, "没有手机号码,怎么给您发验证码呢?");
//                    return;
//                }
//                getCodeByHttp(phoneStr);
                setUnable();
                break;

            case R.id.id_btn_login:
                ActivityRegisterPassword_.intent(ActivityRegisterTwo.this).start();
                break;
        }
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onClickBack() {
        finish();
    }


    private void getCodeByHttp(String phone) {
        Map<String, String> params = new HashMap<>();
        params.put("phone", phone);
        new NiceAsyncTask(false) {

            @Override
            public void loadSuccess(BaseBean bean) {

            }

            @Override
            public void exception() {

            }
        }.post(true, RequestAPI.SMS_REQUEST, params, BaseBean.class);
    }


    private void checkCodeByHttp(String phone, String code) {
        Map<String, String> params = new HashMap<>();
        params.put("phone", phone);
        params.put("code", code);
        new NiceAsyncTask(false) {

            @Override
            public void loadSuccess(BaseBean bean) {

            }

            @Override
            public void exception() {

            }
        }.post(true, RequestAPI.SMS_VALIDATE, params, BaseBean.class);
    }



}
