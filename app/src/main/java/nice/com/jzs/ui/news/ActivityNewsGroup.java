package nice.com.jzs.ui.news;

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

@EActivity(R.layout.activity_news_group)
public class ActivityNewsGroup extends AbstractActivity {


    @ViewById(R.id.tabs)
    PagerSlidingTabStrip tabStrip;

    @ViewById(R.id.pager)
    ViewPager pager;

    private List<NewsGroupListBean.DataBean.NewsGroupBean> groupBeanList = new ArrayList<>();
    private List<ViewNewsIist> views = new ArrayList<ViewNewsIist>();

    private NewsGroupAdapter adapter;


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
                NewsGroupListBean listBean = (NewsGroupListBean) bean;
                if (listBean != null) {
                    updateView(listBean);
                }
            }

            @Override
            public void exception() {

            }
        }.post(true, RequestAPI.API_JZB_NEWS_GROUP, params, NewsGroupListBean.class);
    }


    private void updateView(NewsGroupListBean listBean) {

        groupBeanList.clear();
        groupBeanList.addAll(listBean.getData().getNews_group());
        views.clear();
        for (NewsGroupListBean.DataBean.NewsGroupBean groupBean : listBean.getData().getNews_group()) {
            ViewNewsIist newsIist = new ViewNewsIist();
            newsIist.setData(groupBean);
            views.add(newsIist);
        }

        adapter = new NewsGroupAdapter(getSupportFragmentManager());
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

    class NewsGroupAdapter extends FragmentPagerAdapter {
        public NewsGroupAdapter(FragmentManager fm) {
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
