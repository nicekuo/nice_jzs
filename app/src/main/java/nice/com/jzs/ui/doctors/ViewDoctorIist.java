package nice.com.jzs.ui.doctors;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nice.com.nice_library.bean.BaseBean;
import nice.com.jzs.R;
import nice.com.jzs.background.RequestAPI;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.ui.ErrorViewForReload;

import java.util.HashMap;
import java.util.Map;

import cn.finalteam.loadingviewfinal.ListViewFinal;
import cn.finalteam.loadingviewfinal.OnLoadMoreListener;
import cn.finalteam.loadingviewfinal.SwipeRefreshLayoutFinal;

/**
 * Created by ${nice} on ${2016年04月29日14:09:09}.
 */
public class ViewDoctorIist extends Fragment implements SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener {

    private SwipeRefreshLayoutFinal refresh_layout;
    private ListViewFinal news_list;
    private ErrorViewForReload errorView;
    private int page = 1;
    private int size = 20;
    private AbstractActivity activity;
    private DoctorListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_news_list, container, false);
        initView(view);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (AbstractActivity) getActivity();
    }

    private void initView(View view) {
        refresh_layout = (SwipeRefreshLayoutFinal) view.findViewById(R.id.refresh_layout);
        news_list = (ListViewFinal) view.findViewById(R.id.news_list);
        errorView = (ErrorViewForReload) view.findViewById(R.id.errorView);

        refresh_layout.setOnRefreshListener(this);
        news_list.setOnLoadMoreListener(this);
        refresh_layout.autoRefresh();
    }

    public void setData(DoctorsGroupListBean.DataBean.DoctorGroupBean groupBean){
//        refresh_layout.autoRefresh();
    }

    private void getData() {
        Map<String, String> params = new HashMap<>();
        activity.new NiceAsyncTask() {

            @Override
            public void loadSuccess(BaseBean bean) {
                DoctorListBean listBean = (DoctorListBean) bean;
                if (listBean!=null&&listBean.getData()!=null){
                    if (page == 1){
                        refresh_layout.onRefreshComplete();
                        if (adapter == null){
                            adapter = new DoctorListAdapter(listBean.getData().getDoctor_list(),activity,null,null);
                            news_list.setAdapter(adapter);
                        }else {
                            adapter.setData(listBean.getData().getDoctor_list());
                        }
                    }else {
                        news_list.onLoadMoreComplete();
                        adapter.addData(listBean.getData().getDoctor_list());
                    }
                    if (listBean.getData().isIsLastPage()){
                        news_list.setHasLoadMore(false);
                    }else {
                        news_list.setHasLoadMore(true);
                    }
                }
            }

            @Override
            public void exception() {

            }
        }.post(true, RequestAPI.API_JZB_DOCTORS_LIST, params, DoctorListBean.class);
    }

    @Override
    public void loadMore() {
        page++;
        getData();
    }

    @Override
    public void onRefresh() {
        page = 1;
        getData();
    }
}
