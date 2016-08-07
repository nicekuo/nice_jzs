package nice.com.jzs.ui.main;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import nice.com.jzs.camera.FileUtil;
import nice.com.jzs.camera.PathManager;
import nice.com.jzs.ui.setting.ActivityAbout_;
import nice.com.nice_library.CoreApplication;
import nice.com.nice_library.util.IntentUtil;
import nice.com.nice_library.widget.image.SFImageView;
import nice.com.jzs.R;
import nice.com.jzs.background.ConfigValue;
import nice.com.jzs.background.JICHEApplication;
import nice.com.jzs.background.account.Account;
import nice.com.jzs.core.AbstractFragment;
import nice.com.jzs.ui.setting.ActivityPersonalCenter_;
import nice.com.jzs.ui.setting.MeSettingAdapter;
import nice.com.jzs.ui.setting.MineBean;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    @ViewById(R.id.id_tv_about)
    TextView id_tv_about;

    MeSettingAdapter adapter;

    private String cacheTips;


    public static final int kSettingRequestCode = 1034;

    @AfterViews
    void init() {
        initUserLayout();
        initModelList();
        registerReceiver();
        new CalcuFolderSizeAsy().execute();
        id_tv_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityAbout_.intent(getActivity()).start();
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
        if (TextUtils.isEmpty(account.avatar)){
            id_img_user_img.SFSetImageUrl("http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg");
        }else {
            id_img_user_img.SFSetImageUrl(account.avatar);
        }
        id_tv_nick_name.setText(account.nickName);
    }


    private void updateCartTips() {
        MineBean.DataBean.MinePromptsBean m2 = mdatas.get(1);
        adapter.notifyDataSetChanged();
    }

    private void initModelList() {
        mdatas.clear();

        MineBean.DataBean.MinePromptsBean m1 = new MineBean.DataBean.MinePromptsBean();
        m1.setIcon_id(R.drawable.icon_me_record);
        m1.setName(getString(R.string.hint_my_zicha));
        m1.setClassify("0");

        MineBean.DataBean.MinePromptsBean m2 = new MineBean.DataBean.MinePromptsBean();
        m2.setIcon_id(R.drawable.icon_me_collect_tocdor);
        m2.setName(getString(R.string.hint_my_doctor));
        m2.setPrompt("");
        m2.setClassify("1");

        MineBean.DataBean.MinePromptsBean m3 = new MineBean.DataBean.MinePromptsBean();
        m3.setIcon_id(R.drawable.icon_me_collect_news);
        m3.setName(getString(R.string.hint_my_news));
        m3.setClassify("2");

        MineBean.DataBean.MinePromptsBean m4 = new MineBean.DataBean.MinePromptsBean();
        m4.setIcon_id(R.drawable.icon_me_clear);
        m4.setName(getString(R.string.hint_my_clear));
        m4.setPrompt(cacheTips);
        m4.setClassify("3");

        MineBean.DataBean.MinePromptsBean m5 = new MineBean.DataBean.MinePromptsBean();
        m5.setIcon_id(R.drawable.icon_me_update);
        m5.setName(getString(R.string.hint_my_update));
        m5.setClassify("4");

        MineBean.DataBean.MinePromptsBean m6 = new MineBean.DataBean.MinePromptsBean();
        m6.setIcon_id(R.drawable.icon_me_suggest);
        m6.setName(getString(R.string.hint_my_suggest));
        m6.setClassify("5");


        MineBean.DataBean.MinePromptsBean m7 = new MineBean.DataBean.MinePromptsBean();
        m7.setIcon_id(R.drawable.icon_me_about);
        m7.setName(getString(R.string.hint_my_about));
        m7.setClassify("6");

        mdatas.add(m1);
        mdatas.add(m2);
        mdatas.add(m3);
        mdatas.add(m4);
        mdatas.add(m5);
        mdatas.add(m6);
        mdatas.add(m7);
        adapter = new MeSettingAdapter(mdatas, getActivity(), null, null);
        id_list.setAdapter(adapter);
    }

    class CalcuFolderSizeAsy extends AsyncTask<Object, Object, String> {
        @Override
        protected String doInBackground(Object... objects) {
            File cacheDir = new File(CoreApplication.IMAGE_DIR);
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            try {
                long size = FileUtil.getFolderSize(cacheDir);
                return size + " M";
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            cacheTips = result;
            initModelList();
        }
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
//                getMineData();
            }

            if (ConfigValue.kMeFragmentAvatar.equals(action)) {
                initUserLayout();
            }

            if (ConfigValue.kProductCartCountBroadcast.equals(action)) {
                updateCartTips();
            }
            if (ConfigValue.kMeFragmentLogin.equals(action)) {
                initUserLayout();
//                getMineData();
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
