package nice.com.jzs.ui.register;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPI;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.Map;

import nice.com.jzs.R;
import nice.com.jzs.background.ConfigValue;
import nice.com.jzs.background.JICHEApplication;
import nice.com.jzs.background.RequestAPI;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.ui.account.LoginBean;
import nice.com.jzs.ui.setting.ActivityPwdLogin_;
import nice.com.nice_library.bean.BaseBean;
import nice.com.nice_library.util.IntentUtil;
import nice.com.nice_library.util.StringUtil;
import nice.com.nice_library.util.ToastUtil;


/**
 * Created by BaoLongxiang on 2016/2/18.
 * 登陆
 */
@EActivity(R.layout.activity_register_one)
public class ActivityRegisterOne extends AbstractActivity {

    @ViewById(R.id.id_ev_phone)
    EditText idEvPhone;
    @ViewById(R.id.id_btn_login)
    TextView idBtnLogin;
    @ViewById(R.id.text)
    TextView text;


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
    }

    @AfterViews
    void initView() {

        titleView.mTitle.setText("注册账号");
        text.setText(StringUtil.getHtmlStr("我已阅读并接受", "《协议事宜》"));
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = RequestAPI.OFFICIAL_BASE_URL + "registrationAgreement/index";
//                ActivityWebView_.intent(LoginActivity.this).url(url).start();
            }
        });

    }


    @Click({R.id.id_btn_login})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_btn_login://登陆按钮
                ActivityRegisterTwo_.intent(ActivityRegisterOne.this).start();
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


}
