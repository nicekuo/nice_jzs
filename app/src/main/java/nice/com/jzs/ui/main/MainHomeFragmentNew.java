package nice.com.jzs.ui.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import nice.com.jzs.camera.ActivityCapture;
import nice.com.nice_library.bean.BaseBean;
import nice.com.nice_library.nice_view.ViewBannerAutoScroll;
import nice.com.jzs.R;
import nice.com.jzs.background.AppInfo;
import nice.com.jzs.background.ConfigValue;
import nice.com.jzs.background.RequestAPI;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.core.AbstractFragment;
import nice.com.jzs.ui.ErrorViewForReload;
import nice.com.jzs.ui.doctors.DoctorItemBean;
import nice.com.jzs.ui.news.NewsListItemBean;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nice on 16/3/16.
 */

@EFragment(R.layout.fragment_main_home)
public class MainHomeFragmentNew extends AbstractFragment {


    @ViewById(R.id.content_container)
    LinearLayout content_container;

    @ViewById(R.id.errorView)
    ErrorViewForReload errorView;

    @ViewById(R.id.message)
    ImageView message;

    @ViewById(R.id.xiaoren)
    ImageView xiaoren;



    @AfterViews
    void initView() {
        message.setImageResource(R.drawable.icon_message);
        xiaoren.setImageResource(R.drawable.icon_xiaoren);
        xiaoren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ActivityCapture.class);
                getActivity().startActivity(intent);
            }
        });
        errorView.register(new ErrorViewForReload.OnClickForReloadListener() {
            @Override
            public void onClickReload() {
                getDatas();
            }
        });
        getDatas();
        registerBroadCastReceiver();
    }


    @Override
    public void onStop() {
        super.onStop();
    }


    /**
     * 初始化界面
     */
    void getDatas() {
        errorView.setVisibility(View.GONE);
        Map<String,String> params = new HashMap<>();
        ((AbstractActivity) getActivity()).new NiceAsyncTask(false) {
            @SuppressWarnings("static-access")
            @Override
            public void loadSuccess(BaseBean bean) {
                HomeBaen homeBaen = (HomeBaen) bean;
                if (homeBaen != null) {
                    initView(homeBaen);
                }
            }

            @Override
            public void exception() {
                errorView.setVisibility(View.VISIBLE);
            }
        }.post(true, RequestAPI.API_JZB_HOME_INDEX, params, HomeBaen.class);
    }

    private void initView(HomeBaen homeBaen) {

        content_container.removeAllViews();

        if (homeBaen.getData() == null) {
            return;
        }

        if (homeBaen.getData().getBanner() != null && homeBaen.getData().getBanner().size() > 0) {

            final List<HomeBaen.DataBean.BannerBean> bannerBeans = homeBaen.getData().getBanner();
            List<String> imageUrls = new ArrayList<>();
            for (HomeBaen.DataBean.BannerBean itemBean : homeBaen.getData().getBanner()) {
                imageUrls.add(itemBean.getImg());
            }
            ViewBannerAutoScroll viewBannerAutoScroll = new ViewBannerAutoScroll(getActivity());
            viewBannerAutoScroll.setScaleType(ImageView.ScaleType.CENTER_CROP);
            viewBannerAutoScroll.setRatio(0.4f);
            viewBannerAutoScroll.setData(imageUrls);
            viewBannerAutoScroll.register(new ViewBannerAutoScroll.OnClickOneImageListener() {
                @Override
                public void onClickOne(int index) {

                    if (bannerBeans == null && bannerBeans.size() >= index + 1) {
                        return;
                    }
                    HomeBaen.DataBean.BannerBean bannerBean = bannerBeans.get(index);
                    if (!TextUtils.isEmpty(bannerBean.getUrl())) {
                        ActivityWebView_.intent(getActivity()).url(bannerBean.getUrl()).start();
                    }
                }
            });
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 20, 0, 20);
            content_container.addView(viewBannerAutoScroll, params);
        }

        if (homeBaen.getData().getNews() != null && homeBaen.getData().getNews().getNews_list() != null) {
            ViewHomeTitle homeTitle = new ViewHomeTitle(getActivity());
            homeTitle.setData(R.drawable.icon_news, homeBaen.getData().getNews().getTitle());
            content_container.addView(homeTitle);
            if (homeBaen.getData().getNews().getNews_list().size() > 0) {
                for (NewsListItemBean itemBean : homeBaen.getData().getNews().getNews_list()) {
                    ViewHomeNewsitem newsitem = new ViewHomeNewsitem(getActivity());
                    newsitem.setData(itemBean);
                    content_container.addView(newsitem);
                }
            }
        }

        if (homeBaen.getData().getDoctor() != null && homeBaen.getData().getDoctor().getDoctor_list() != null) {
            ViewHomeTitle homeTitle = new ViewHomeTitle(getActivity());
            homeTitle.setData(R.drawable.icon_doctor, homeBaen.getData().getDoctor().getTitle());
            content_container.addView(homeTitle);
            LinearLayout linearLayout = new LinearLayout(getActivity());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            int width = AppInfo.width;

            if (homeBaen.getData().getDoctor().getDoctor_list().size() > 0) {
                for (DoctorItemBean itemBean : homeBaen.getData().getDoctor().getDoctor_list()) {
                    ViewHomeDoctorItem item = new ViewHomeDoctorItem(getActivity());
                    item.setData(itemBean);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width / 3, ViewGroup.LayoutParams.WRAP_CONTENT);
                    linearLayout.addView(item, params);
                }
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 500);
                params.bottomMargin = 200;
                content_container.addView(linearLayout, params);
            }
        }
    }



    private BroadcastReceiver mBroadCastRecevier = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(ConfigValue.ACTION_LOGOIN_STATUS_CHANGED)) {
            }
            if (ConfigValue.kMainHomeCarBroadcast.equals(action)) {
            }
        }
    };

    public void registerBroadCastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConfigValue.ACTION_LOGOIN_STATUS_CHANGED);
        intentFilter.addAction(ConfigValue.kMainHomeCarBroadcast);
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(mBroadCastRecevier, intentFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mBroadCastRecevier != null) {
            LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mBroadCastRecevier);
            mBroadCastRecevier = null;
        }
    }
}
