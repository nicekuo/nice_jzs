package nice.com.jzs.ui.register;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.content.LocalBroadcastManager;
import android.text.Html;
import android.text.Spanned;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nice.com.jzs.R;
import nice.com.jzs.background.ConfigValue;
import nice.com.jzs.background.JICHEApplication;
import nice.com.jzs.background.RequestAPI;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.ui.ViewProgress;
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

    @ViewById(R.id.view_progress)
    ViewProgress view_progress;


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
        images.add(R.drawable.icon_circle_true);
        images.add(R.drawable.icon_circle_false);
        images.add(R.drawable.icon_circle_false);
        images.add(R.drawable.icon_circle_false);
        images.add(R.drawable.icon_circle_false);
        images.add(R.drawable.icon_circle_false);
        view_progress.setImages(images);

        titleView.mTitle.setText("注册账号");
        text.setText(getHtmlStr());
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = RequestAPI.OFFICIAL_BASE_URL + "registrationAgreement/index";
//                ActivityWebView_.intent(LoginActivity.this).url(url).start();
            }
        });

    }

    public static Spanned getHtmlStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<font color = " + Color.parseColor("#666666") + "> 点击上面的注册按钮即同意 </font>");
        stringBuffer.append("<font color = " + Color.parseColor("#33c8ca") + "> 服务协议 </font>");
        stringBuffer.append("<font color = " + Color.parseColor("#666666") + "> 和 </font>");
        stringBuffer.append("<font color = " + Color.parseColor("#33c8ca") + "> 隐私政策 </font>");
        return Html.fromHtml(stringBuffer.toString());
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
