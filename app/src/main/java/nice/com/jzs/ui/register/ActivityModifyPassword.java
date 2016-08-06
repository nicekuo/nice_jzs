package nice.com.jzs.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
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
import nice.com.nice_library.util.encrypt.MD5Util;


/**
 * Created by BaoLongxiang on 2016/2/18.
 * 登陆
 */
@EActivity(R.layout.activity_register_password)
public class ActivityModifyPassword extends AbstractActivity {


    @Extra
    String phone;

    @ViewById(R.id.id_btn_login)
    TextView idBtnLogin;

    @ViewById(R.id.view_progress)
    ViewProgress view_progress;

    @ViewById(R.id.password_one)
    EditText passwordOne;

    @ViewById(R.id.password_two)
    EditText passwordTwo;

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

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.icon_select_true);
        images.add(R.drawable.icon_select_true);
        images.add(R.drawable.icon_circle_true);
        view_progress.setImages(images);

        titleView.mTitle.setText("重设密码");
    }


    @Click({R.id.id_btn_login})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_btn_login://登陆按钮
                tryRegisterPassword();
                break;
        }
    }

    private void tryRegisterPassword() {
        if (checkPassword()) {
            Map<String, String> map = new HashMap<>();
            map.put("phone", phone);
            map.put("password", MD5Util.md5(passwordOne.getText().toString()));
            new NiceAsyncTask(false) {

                @Override
                public void loadSuccess(BaseBean bean) {
                    if (bean.result != 0) {
                        ToastUtil.showToastMessage(ActivityModifyPassword.this, bean.error_info);
                    } else {
                        ActivityRegisterNickName_.intent(ActivityModifyPassword.this).start();
                    }
                }

                @Override
                public void exception() {

                }
            }.post(RequestAPI.API_JZB_REGISTER_PASSWORD, map, BaseBean.class);


        }
    }

    private boolean checkPassword() {
        if (TextUtils.isEmpty(passwordOne.getText())) {
            ToastUtil.showToastMessage(ActivityModifyPassword.this, "请输入密码");
            return false;
        }

        if (TextUtils.isEmpty(passwordTwo.getText())) {
            ToastUtil.showToastMessage(ActivityModifyPassword.this, "请再次输入密码");
            return false;
        }

        if (!passwordTwo.getText().toString().equals(passwordOne.getText().toString())) {
            ToastUtil.showToastMessage(ActivityModifyPassword.this, "输入的两次密码不一致");
            return false;
        }

        return true;
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
