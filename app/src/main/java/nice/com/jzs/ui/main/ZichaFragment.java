package nice.com.jzs.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import cn.finalteam.loadingviewfinal.ListViewFinal;
import cn.finalteam.loadingviewfinal.SwipeRefreshLayoutFinal;
import nice.com.jzs.R;
import nice.com.jzs.background.RequestAPI;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.core.AbstractFragment;
import nice.com.jzs.ui.ErrorViewForReload;
import nice.com.jzs.ui.zicha.ActivityZichaOne_;
import nice.com.jzs.ui.zicha.ViewZichaListItem;
import nice.com.jzs.ui.zicha.ZichaListBean;
import nice.com.nice_library.adapter.SFBaseAdapter;
import nice.com.nice_library.bean.BaseBean;


/**
 * Created by sufun_job on 2016/2/16.
 *
 * @description 商家列表主界面
 */
@EFragment(R.layout.fragment_zicha)
public class ZichaFragment extends AbstractFragment implements SwipeRefreshLayout.OnRefreshListener {

    @ViewById(R.id.news_list)
    ListViewFinal newsList;
    @ViewById(R.id.errorView)
    ErrorViewForReload errorView;
    @ViewById(R.id.refresh_layout)
    SwipeRefreshLayoutFinal refreshLayout;

    @ViewById(R.id.xiaoren)
    ImageView xiaoren;

    private ZichaListAdapter adapter;

    @AfterViews
    void init() {
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.autoRefresh();

        xiaoren.setImageResource(R.drawable.icon_home_zicha_unpressed);
        xiaoren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityZichaOne_.intent(getActivity()).start();
            }
        });
        getList();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            if (refreshLayout != null) {
                refreshLayout.autoRefresh();
            }
        }
    }

    private void getList() {
        Map<String, String> map = new HashMap<>();
        ((AbstractActivity) getActivity()).new NiceAsyncTask(false) {
            @Override
            public void loadSuccess(BaseBean bean) {
                refreshLayout.onRefreshComplete();
                ZichaListBean listBean = (ZichaListBean) bean;
                if (listBean.getData() != null && listBean.getData() != null) {
                    if (adapter == null) {
                        adapter = new ZichaListAdapter(listBean.getData(), getActivity(), null, null);
                        newsList.setAdapter(adapter);
                    } else {
                        adapter.setData(listBean.getData());
                        adapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void exception() {
                refreshLayout.onRefreshComplete();
            }
        }.post(false,RequestAPI.API_JZB_ZICHA_LIST, map, ZichaListBean.class);
    }

    @Override
    public void onRefresh() {
        getList();
    }


    private class ZichaListAdapter extends SFBaseAdapter<ZichaListBean.DataBean> {

        /**
         * @param data    用于展示的列表数据
         * @param context 传入的上下文
         * @param object  引用者
         * @param exObj   此字段用于后期的一些扩展字段，一般没有效果
         */
        public ZichaListAdapter(List<ZichaListBean.DataBean> data, Context context, Object object, Object exObj) {
            super(data, context, object, exObj);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewZichaListItem listItem = null;
            if (convertView == null) {
                listItem = new ViewZichaListItem(mContext);
            } else {
                listItem = (ViewZichaListItem) convertView;
            }
            listItem.setData((ZichaListBean.DataBean) getItem(position));
            return listItem;
        }
    }


}
