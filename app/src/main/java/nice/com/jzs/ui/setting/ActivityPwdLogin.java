package nice.com.jzs.ui.setting;

import android.content.Intent;
import android.os.Bundle;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import nice.com.jzs.R;
import nice.com.jzs.background.JICHEApplication;
import nice.com.jzs.background.RequestAPI;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.ui.ViewProgress;
import nice.com.jzs.ui.account.LoginBean;
import nice.com.jzs.ui.register.ActivityModifyPasswordPhone_;
import nice.com.jzs.ui.register.ActivityRegisterOne_;
import nice.com.nice_library.bean.BaseBean;
import nice.com.nice_library.util.encrypt.MD5Util;

/**
 * Created by admin on 2016/3/24.
 */
@EActivity(R.layout.activity_user_name_login)
public class ActivityPwdLogin extends AbstractActivity {

    @ViewById(R.id.id_et_user_name)
    EditText idUserName;
    @ViewById(R.id.id_et_pwd)
    EditText idPwd;
    @ViewById(R.id.id_btn_pwd_login)
    TextView idPwdLogin;
    @ViewById(R.id.register)
    TextView register;

    @ViewById(R.id.forget_password)
    TextView forget_password;

    @Click(R.id.id_btn_pwd_login)
    void onClick(View v) {
        login();
    }

    @AfterViews
    void initView() {


        idUserName.setText("18533675226");
        idPwd.setText("123456");
        titleView.mTitle.setText("登录");
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityRegisterOne_.intent(ActivityPwdLogin.this).start();
            }
        });
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityModifyPasswordPhone_.intent(ActivityPwdLogin.this).start();
            }
        });
    }

    private void login() {
        Map<String, String> params = new HashMap<>();
        params.put("phoneNum", idUserName.getText().toString());
//        params.put("password", MD5Util.md5(idPwd.getText().toString()));
        params.put("password", (idPwd.getText().toString()));
        new NiceAsyncTask(false) {
            @Override
            public void loadSuccess(BaseBean bean) {
                LoginBean loginBean = (LoginBean) bean;
                if (loginBean != null && loginBean.getData() != null && !TextUtils.isEmpty(loginBean.getData().getToken())) {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(ActivityLogin.kLoginBean, loginBean);
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    JICHEApplication.getInstance().showJsonErrorToast();
                }
            }

            @Override
            public void exception() {

            }
        }.post(true, RequestAPI.API_JZB_LOGIN_PHONE, params, LoginBean.class);

    }


    @Override
    protected void onClickBack() {
        finish();
    }
}
