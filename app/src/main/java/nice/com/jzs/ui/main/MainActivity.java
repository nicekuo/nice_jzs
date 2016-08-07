package nice.com.jzs.ui.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import nice.com.nice_library.bean.BaseBean;
import nice.com.nice_library.util.CoreUtil;
import nice.com.nice_library.util.ToastUtil;
import nice.com.jzs.R;
import nice.com.jzs.background.CommonPreference;
import nice.com.jzs.background.ConfigValue;
import nice.com.jzs.background.JICHEApplication;
import nice.com.jzs.background.RequestAPI;
import nice.com.jzs.background.account.Account;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.utils.IntentParseUtil;

import com.tencent.android.tpush.XGPushManager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by sufun_job on 2016/1/19.
 *
 * @desctiption 项目的首页
 */
@EActivity(R.layout.home_main_layout)
public class MainActivity extends AbstractActivity {

    public static final int HOME = 0;
    public static final int ZICHA = 1;
    public static final int MESSAGE = 2;
    public static final int ME = 3;

    private Fragment preFragment; // 上一个Fragment
    private Fragment[] fragment = new Fragment[4];

    @ViewById(R.id.id_zicha)
    LinearLayout id_zicha;
    @ViewById(R.id.id_home)
    LinearLayout id_home;
    @ViewById(R.id.id_me)
    LinearLayout id_me;
    @ViewById(R.id.id_message)
    LinearLayout id_message;

    @ViewById(R.id.id_zicha_image)
    ImageView id_zicha_image;
    @ViewById(R.id.id_home_image)
    ImageView id_home_image;
    @ViewById(R.id.id_me_image)
    ImageView id_me_image;
    @ViewById(R.id.id_message_image)
    ImageView id_messge_image;

    @ViewById(R.id.id_shop_text)
    TextView id_shop_text;
    @ViewById(R.id.id_home_text)
    TextView id_home_text;
    @ViewById(R.id.id_me_text)
    TextView id_me_text;
    @ViewById(R.id.id_message_text)
    TextView id_message_text;

    @ViewById(R.id.splashLayout)
    View splashLayout;

    private static int TIME_LONG = 3 * 1000;
    private long lastTime;
    private final int SPLASH_TIME = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.isTemplate = false;
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if (intent != null) {
            IntentParseUtil.getInstance().parseIntentType(intent, MainActivity.this);
        }
        registerBroadCastReceiver();
        initPushSDK();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            IntentParseUtil.getInstance().parseIntentType(intent, MainActivity.this);
        }
    }

    public void parseIntentInMainActivity(Intent intent) {
        String type = intent.getStringExtra(ConfigValue.kLaunchMainAcKey);
        if (ConfigValue.kLaunchMainAcTypeShowHome.equals(type)) {
            doShowHome();
        }
        if (ConfigValue.kLaunchMainAcTypeShowZicha.equals(type)){
            doShowZICHA();
        }
    }

    private void initPushSDK() {
        // 如果需要知道注册是否成功，请使用registerPush(getApplicationContext(), XGIOperateCallback)带callback版本
        // 如果需要绑定账号，请使用registerPush(getApplicationContext(),account)版本
        // 具体可参考详细的开发指南
        // 传递的参数为ApplicationContext
        Context context = getApplicationContext();
        XGPushManager.registerPush(context);
        // 开启logcat输出，方便debug，发布时请关闭
//        if (BuildConfig.LOG_DEBUG) {
//            XGPushConfig.enableDebug(context, true);
//        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
            broadcastReceiver = null;
        }
    }

    @Override
    protected void onClickBack() {

    }

    @AfterViews
    void init() {
        findViewById(R.id.id_home_fragment).postDelayed(new Runnable() {
            @Override
            public void run() {
                doShowFragment(HOME);
            }
        },500);
        splashLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                splashLayout.setVisibility(View.GONE);
                MainActivity.this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        }, SPLASH_TIME);
        //        tryToUpgrade();

//        initSpalshCenter();
    }


//    private void tryToUpgrade() {
//        Map<String, String> params = new HashMap<>();
//        new NiceAsyncTask(false) {
//            @Override
//            public void loadSuccess(BaseBean bean) {
//                UpgradeBean upgradeBean = (UpgradeBean) bean;
//                if (upgradeBean != null && upgradeBean.getData() != null && !TextUtils.isEmpty(upgradeBean.getData().getUrl())) {
//                    updateVersion(upgradeBean);
//                }
//            }
//
//            @Override
//            public void exception() {
//
//            }
//        }.post(RequestAPI.API_TRY_TO_UPDATE_VERSION, params, UpgradeBean.class);
//    }


    /**
     * 底部点击事件
     */
    @Click({R.id.id_zicha, R.id.id_home, R.id.id_me,R.id.id_message})
    void OnTabClickEvent(View view) {
        switch (view.getId()) {
            case R.id.id_zicha:
                doShowZICHA();
                break;
            case R.id.id_home:
                doShowHome();
                break;
            case R.id.id_me:
                doShowMe();
                break;
            case R.id.id_message:
                doShowMessage();
                break;
        }
    }

    /**
     * index建议使用本类中的常量
     *
     * @param fragmentIndex
     */
    public void doShowFragment(int fragmentIndex) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment temp = this.fragment[fragmentIndex];
        if (temp == null) {
            switch (fragmentIndex) {
                case ZICHA:
                    this.fragment[fragmentIndex] = new ZichaFragment_();
                    transaction.add(R.id.id_home_fragment, this.fragment[fragmentIndex]);
                    temp = this.fragment[fragmentIndex];
                    break;
                case HOME:
                    this.fragment[fragmentIndex] = new MainHomeFragmentNew_();
                    transaction.add(R.id.id_home_fragment, this.fragment[fragmentIndex]);
                    temp = this.fragment[fragmentIndex];
                    break;
                case ME:
                    this.fragment[fragmentIndex] = new MeFragment_();
                    transaction.add(R.id.id_home_fragment, this.fragment[fragmentIndex]);
                    temp = this.fragment[fragmentIndex];
                    break;
                case MESSAGE:
                    this.fragment[fragmentIndex] = new MessageListFragment_();
                    transaction.add(R.id.id_home_fragment, this.fragment[fragmentIndex]);
                    temp = this.fragment[fragmentIndex];
                    break;
            }
        }
        //开始执行窗口的隐藏
        for (int i = 0; i < this.fragment.length; i++) {
            if (this.fragment[i] != null) {
                if (this.fragment[i] == temp && temp != null) {
                    temp.setUserVisibleHint(true);
                    transaction.show(temp);
                } else {
                    this.fragment[i].setUserVisibleHint(false);
                    transaction.hide(this.fragment[i]);
                }
            }
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 展示周边的商品列表
     */
    void doShowZICHA() {
        if (JICHEApplication.getInstance().getLoginState()) {
            doResetTabIcon();
            id_zicha_image.setBackgroundResource(R.drawable.icon_home_zicha_pressed);
            id_shop_text.setTextColor(getResources().getColor(R.color.blue));
            doShowFragment(ZICHA);
        } else {
            JICHEApplication.getInstance().gotoLogin(MainActivity.this);
        }
    }

    /**
     * 重置图标
     */
    void doResetTabIcon() {
        id_home_image.setBackgroundResource(R.drawable.icon_home_unpressed);
        id_me_image.setBackgroundResource(R.drawable.icon_home_me_unpressed);
        id_zicha_image.setBackgroundResource(R.drawable.icon_home_zicha_unpressed);
        id_home_text.setTextColor(getResources().getColor(R.color.common_grey));
        id_shop_text.setTextColor(getResources().getColor(R.color.common_grey));
        id_me_text.setTextColor(getResources().getColor(R.color.common_grey));
        id_messge_image.setBackgroundResource(R.drawable.icon_home_message_unpressed);
        id_message_text.setTextColor(getResources().getColor(R.color.common_grey));
    }

    /**
     * 展示主页
     */
    void doShowHome() {
        doResetTabIcon();
        id_home_image.setBackgroundResource(R.drawable.icon_home_pressed);
        id_home_text.setTextColor(getResources().getColor(R.color.blue));
        doShowFragment(HOME);
    }

    /**
     * 展示消息列表
     */
    void doShowMessage() {

        doResetTabIcon();
        id_messge_image.setBackgroundResource(R.drawable.icon_home_message_pressed);
        id_message_text.setTextColor(getResources().getColor(R.color.blue));
        doShowFragment(MESSAGE);
//            doResetTabIcon();
//            id_messge_image.setBackgroundResource(R.drawable.icon_home_me_pressed);
//            id_message_text.setTextColor(getResources().getColor(R.color.blue));
//            doShowFragment(MESSAGE);
//        } else {
//            JICHEApplication.getInstance().gotoLogin(MainActivity.this);
//        }
    }

    /**
     * 展示用户个人主页
     */
    void doShowMe() {
        if (JICHEApplication.getInstance().getLoginState()) {
            doResetTabIcon();
            id_me_image.setBackgroundResource(R.drawable.icon_home_me_pressed);
            id_me_text.setTextColor(getResources().getColor(R.color.blue));
            doShowFragment(ME);
        } else {
            JICHEApplication.getInstance().gotoLogin(MainActivity.this);
        }
    }


    @Override
    public void onBackPressed() {
        if (isDialogShowing()) {
            return;
        }
        if (isImageViewShowing()) {
            return;
        }
        long t = System.currentTimeMillis();
        if (t - lastTime < TIME_LONG) {
            CoreUtil.exitApp();
        } else {
            ToastUtil.showToastMessage(MainActivity.this, "再按一次返回键退出");
            lastTime = t;
            return;
        }
        super.onBackPressed();
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (ConfigValue.kPushTokenUpdate.equals(action)) {
//                setPushToken();
            }
        }
    };

    public void registerBroadCastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConfigValue.kPushTokenUpdate);
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter);
    }

    private void setPushToken() {
        String push_token = CommonPreference.getToken();
        Map<String, String> params = new HashMap<>();
        params.put("xinge_token", push_token);
        Account account = JICHEApplication.getInstance().getAccount();
        String token = "";
        if (account != null) {
            token = account.token;
        }
        if (!TextUtils.isEmpty(token)) {
            params.put("token", token);
        }

        new NiceAsyncTask(false) {

            @Override
            public void loadSuccess(BaseBean bean) {

            }

            @Override
            public void exception() {

            }
        }.post(false, RequestAPI.API_MEMBER_PUSH_TOKEN, params, BaseBean.class);
    }


}
