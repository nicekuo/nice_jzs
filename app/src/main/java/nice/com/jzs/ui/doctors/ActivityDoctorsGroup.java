package nice.com.jzs.ui.doctors;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;

import nice.com.nice_library.bean.BaseBean;
import nice.com.nice_library.wigets.PagerSlidingTabStrip;
import nice.com.jzs.R;
import nice.com.jzs.background.RequestAPI;
import nice.com.jzs.core.AbstractActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ${nice} on ${2016年04月29日14:09:09}.
 */

@EActivity(R.layout.activity_doctors_group)
public class ActivityDoctorsGroup extends AbstractActivity {


    @ViewById(R.id.tabs)
    PagerSlidingTabStrip tabStrip;

    @ViewById(R.id.pager)
    ViewPager pager;

    private List<DoctorsGroupListBean.DataBean.DoctorGroupBean> groupBeanList = new ArrayList<>();
    private List<ViewDoctorIist> views = new ArrayList<ViewDoctorIist>();

    private DoctorGroupAdapter adapter;


    @AfterViews
    void init() {
        getNewsGroupData();
    }

    private void initTabsValue() {
        // 底部游标颜色
        tabStrip.setIndicatorColor(getResources().getColor(R.color.common_red));
        // tab的分割线颜色
        tabStrip.setDividerColor(Color.TRANSPARENT);

        tabStrip.setUnderlineColorResource(R.color.line_color);
        // tab背景
        tabStrip.setBackgroundColor(getResources().getColor(R.color.white));
        // tab底线高度
        tabStrip.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,
                1, getResources().getDisplayMetrics()));
        // 游标高度
        tabStrip.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                3, getResources().getDisplayMetrics()));
        // 正常文字颜色
        tabStrip.setTextColor(getResources().getColor(R.color.blue));
        tabStrip.setTextSize(14);
        tabStrip.setSelectedTextColor(getResources().getColor(R.color.common_red));
        tabStrip.setShouldExpand(true);
    }

    private void getNewsGroupData() {

        Map<String, String> params = new HashMap<>();
        new NiceAsyncTask() {

            @Override
            public void loadSuccess(BaseBean bean) {
                DoctorsGroupListBean listBean = (DoctorsGroupListBean) bean;
                if (listBean != null) {
                    updateView(listBean);
                }
            }


            @Override
            public void exception() {

            }
        }.post(true, RequestAPI.API_JZB_DOCTORS_GROUP, params, DoctorsGroupListBean.class);
    }


    private void updateView(DoctorsGroupListBean listBean) {

        groupBeanList.clear();
        groupBeanList.addAll(listBean.getData().getDoctor_group());
        views.clear();
        for (DoctorsGroupListBean.DataBean.DoctorGroupBean groupBean : listBean.getData().getDoctor_group()) {
            ViewDoctorIist doctorIist = new ViewDoctorIist();
            doctorIist.setData(groupBean);
            views.add(doctorIist);
        }

        adapter = new DoctorGroupAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabStrip.setViewPager(pager);
        if (groupBeanList != null && groupBeanList.size() > 2) {
            pager.setOffscreenPageLimit(((groupBeanList.size() / 3) * 2) + 1);
        } else {
            pager.setOffscreenPageLimit(groupBeanList.size());
        }

        initTabsValue();

    }


    @Override
    protected void onClickBack() {
        finish();
    }

    private class DoctorGroupAdapter extends FragmentPagerAdapter {
        public DoctorGroupAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return views.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return groupBeanList.get(position).getGroup_title();
        }

        @Override
        public int getCount() {
            return groupBeanList.size();
        }
    }
}
