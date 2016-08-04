package nice.com.jzs.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPI;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import nice.com.jzs.R;
import nice.com.jzs.background.AppInfo;
import nice.com.jzs.background.JICHEApplication;
import nice.com.jzs.background.RequestAPI;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.ui.account.LoginBean;
import nice.com.jzs.ui.register.ActivityRegisterOne_;
import nice.com.nice_library.bean.BaseBean;


/**
 * Created by BaoLongxiang on 2016/2/18.
 * 登陆
 */
@EActivity(R.layout.activity_login)
public class ActivityLogin extends AbstractActivity {

    @ViewById(R.id.weichat_login)
    View weichat_login;

    @ViewById(R.id.version)
    TextView version;

    @ViewById(R.id.slogan)
    TextView slogan;

    @ViewById(R.id.id_btn_register)
    TextView idBtnRegister;

    @ViewById(R.id.id_btn_login)
    TextView idBtnLogin;

    @ViewById(R.id.weichat_login_tips)
    TextView weichatLoginTips;

    @AfterViews
    void initView() {
        titleView.mTitle.setText("登录");
        version.setText("v"+AppInfo.cver_name);
        idBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                loginWeChat();
                ActivityRegisterOne_.intent(ActivityLogin.this).start();
            }
        });


    }

    public void loginWeChat() {
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "wechat_sdk_demo_test";
        IWXAPI iwxapi = JICHEApplication.getInstance().getWxApi();
        if (iwxapi != null) {
            iwxapi.sendReq(req);
        }
    }


    @Click({R.id.id_btn_login, R.id.id_txv_login_type_switch, R.id.id_btn_code})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_btn_login://登陆按钮
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


    private void loginByWechat(String code) {
        Map<String, String> params = new HashMap<>();
        params.put("code", code);
        new NiceAsyncTask(false) {

            @Override
            public void loadSuccess(BaseBean bean) {
                LoginBean loginBean = (LoginBean) bean;
//                doLoginSucess(loginBean);
            }

            @Override
            public void exception() {

            }
        }.post(true, RequestAPI.API_MEMBER_LOGIN_WECHAT, params, LoginBean.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
