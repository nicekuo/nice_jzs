package nice.com.jzs.ui.main;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import nice.com.nice_library.bean.BaseBean;
import nice.com.nice_library.util.IntentUtil;
import nice.com.nice_library.widget.image.SFImageView;
import nice.com.jzs.R;
import nice.com.jzs.background.ConfigValue;
import nice.com.jzs.background.JICHEApplication;
import nice.com.jzs.background.RequestAPI;
import nice.com.jzs.background.account.Account;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.core.AbstractFragment;
import nice.com.jzs.ui.setting.ActivityAboutJICHe_;
import nice.com.jzs.ui.setting.ActivityPersonalCenter_;
import nice.com.jzs.ui.setting.MeSettingAdapter;
import nice.com.jzs.ui.setting.MineBean;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sufun_job on 2016/2/16.
 *
 * @description 用户个人主页`
 */
@EFragment(R.layout.setting_me_layout)
public class MeFragment extends AbstractFragment {
    List<MineBean.DataBean.MinePromptsBean> mdatas = new ArrayList<MineBean.DataBean.MinePromptsBean>();

    @ViewById(R.id.id_list)
    ListView id_list;
    @ViewById(R.id.id_imgbtn_person)
    ImageButton idImgBtnPerson;
    @ViewById(R.id.userLayout)
    View userLayout;

    @ViewById(R.id.id_img_user_img)
    SFImageView id_img_user_img;

    @ViewById(R.id.id_tv_nick_name)
    TextView id_tv_nick_name;

    @ViewById(R.id.id_tv_vip)
    TextView id_tv_vip;

    @ViewById(R.id.id_tv_about)
    TextView id_tv_about;

    MeSettingAdapter adapter;


    public static final int kSettingRequestCode = 1034;

    @AfterViews
    void init() {
        initUserLayout();
        initModelList();
//        getMineData();
        registerReceiver();
        id_tv_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityAboutJICHe_.intent(getActivity()).start();
            }
        });
        userLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtil.intentFowardResult(MeFragment.this, ActivityPersonalCenter_.intent(getActivity()).get(), kSettingRequestCode);
            }
        });
    }

    private void initUserLayout() {
        Account account = JICHEApplication.getInstance().getAccount();
        id_img_user_img.SFSetImageUrl(account.avatar);
        id_tv_nick_name.setText(account.nickName);
        id_tv_vip.setText(account.rankname);
    }


    void getMineData() {
        Map<String,String> params = new HashMap<>();
        ((AbstractActivity) getActivity()).new NiceAsyncTask(false) {
            @Override
            public void loadSuccess(BaseBean bean) {
                MineBean mineBean = (MineBean) bean;
                if (mineBean.getData() != null && mineBean.getData().getMine_prompts() != null && mineBean.getData().getMine_prompts().size() > 0) {
                    updateModelList(mineBean);
                } else {
                    JICHEApplication.getInstance().showJsonErrorToast();
                }
            }

            @Override
            public void exception() {

            }
        }.post(true, RequestAPI.API_GET_MINE_ALL, params, MineBean.class);
    }


    void updateModelList(MineBean mineBean) {
        MineBean.DataBean.MinePromptsBean m1 = mdatas.get(0);
        if (mineBean.getData().getMine_prompts().size() > 1) {
            m1.setPrompt(mineBean.getData().getMine_prompts().get(0).getPrompt());
        }

        MineBean.DataBean.MinePromptsBean m3 = mdatas.get(2);
        if (mineBean.getData().getMine_prompts().size() > 3) {
            m3.setPrompt(mineBean.getData().getMine_prompts().get(2).getPrompt());
        }

        MineBean.DataBean.MinePromptsBean m4 = mdatas.get(3);
        if (mineBean.getData().getMine_prompts().size() > 4) {
            m4.setPrompt(mineBean.getData().getMine_prompts().get(3).getPrompt());
        }

        MineBean.DataBean.MinePromptsBean m5 = mdatas.get(4);
        if (mineBean.getData().getMine_prompts().size() >= 5) {
            m5.setPrompt(mineBean.getData().getMine_prompts().get(4).getPrompt());
        }

//        MineBean.DataBean.MinePromptsBean m6 = mdatas.get(5);
//        if (mineBean.getData().getMine_prompts().size() == 6) {
//            m6.setPrompt(mineBean.getData().getMine_prompts().get(5).getPrompt());
//        }
        adapter.notifyDataSetChanged();
    }

    private void updateCartTips() {
        MineBean.DataBean.MinePromptsBean m2 = mdatas.get(1);
        adapter.notifyDataSetChanged();
    }

    private void initModelList() {
        MineBean.DataBean.MinePromptsBean m1 = new MineBean.DataBean.MinePromptsBean();
        m1.setIcon_id(R.drawable.icon_me_my_order);
        m1.setName(getString(R.string.hint_my_order));
        m1.setClassify("0");

        MineBean.DataBean.MinePromptsBean m2 = new MineBean.DataBean.MinePromptsBean();
        m2.setIcon_id(R.drawable.icon_my_shopping_car);
        m2.setName(getString(R.string.hint_my_shop_car));
        m2.setPrompt("");
        m2.setClassify("1");

        MineBean.DataBean.MinePromptsBean m3 = new MineBean.DataBean.MinePromptsBean();
        m3.setIcon_id(R.drawable.icon_my_coupon);
        m3.setName(getString(R.string.hint_my_coupon));
        m3.setClassify("2");

        MineBean.DataBean.MinePromptsBean m4 = new MineBean.DataBean.MinePromptsBean();
        m4.setIcon_id(R.drawable.icon_my_car);
        m4.setName(getString(R.string.hint_my_like_car));
        m4.setClassify("3");

        MineBean.DataBean.MinePromptsBean m5 = new MineBean.DataBean.MinePromptsBean();
        m5.setIcon_id(R.drawable.icon_my_collect);
        m5.setName(getString(R.string.hint_my_collect));
        m5.setClassify("4");

//        MineBean.DataBean.MinePromptsBean m6 = new MineBean.DataBean.MinePromptsBean();
//        m6.setIcon_id(R.drawable.icon_my_message);
//        m6.setName(getString(R.string.hint_my_message));
//        m6.setClassify("5");

        mdatas.add(m1);
        mdatas.add(m2);
        mdatas.add(m3);
        mdatas.add(m4);
        mdatas.add(m5);
        // mdatas.add(m6);
        adapter = new MeSettingAdapter(mdatas, getActivity(), null, null);
        id_list.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == kSettingRequestCode) {
            if (resultCode == Activity.RESULT_OK) {
                JICHEApplication.getInstance().gotoHome(getActivity());
            }
        }
    }


    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (ConfigValue.kMeFragmentTips.equals(action)) {
                getMineData();
            }

            if (ConfigValue.kMeFragmentAvatar.equals(action)){
                initUserLayout();
            }

            if (ConfigValue.kProductCartCountBroadcast.equals(action)) {
                updateCartTips();
            }
            if (ConfigValue.kMeFragmentLogin.equals(action)){
                initUserLayout();
                getMineData();
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(broadcastReceiver);
            broadcastReceiver = null;
        }
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConfigValue.kMeFragmentTips);
        intentFilter.addAction(ConfigValue.kProductCartCountBroadcast);
        intentFilter.addAction(ConfigValue.kMeFragmentAvatar);
        intentFilter.addAction(ConfigValue.kMeFragmentLogin);
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(broadcastReceiver, intentFilter);
    }


}
