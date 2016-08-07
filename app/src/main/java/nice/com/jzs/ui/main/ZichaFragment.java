package nice.com.jzs.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import nice.com.jzs.R;
import nice.com.jzs.background.RequestAPI;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.core.AbstractFragment;
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
public class ZichaFragment extends AbstractFragment {

    @ViewById(R.id.list)
    ListView listView;

    @ViewById(R.id.xiaoren)
    ImageView xiaoren;

    private ZichaListAdapter adapter;

    @AfterViews
    void init() {
        xiaoren.setImageResource(R.drawable.icon_me_clear);
        xiaoren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityZichaOne_.intent(getActivity()).start();
            }
        });
        getList();
    }


    private void getList() {
        Map<String, String> map = new HashMap<>();
        ((AbstractActivity) getActivity()).new NiceAsyncTask(false) {
            @Override
            public void loadSuccess(BaseBean bean) {
                ZichaListBean listBean = (ZichaListBean) bean;
                if (listBean.getData() != null && listBean.getData().getZicha_list() != null) {
                    adapter = new ZichaListAdapter(listBean.getData().getZicha_list(), getActivity(), null, null);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void exception() {

            }
        }.post(RequestAPI.API_JZB_ZICHA_LIST, map, ZichaListBean.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }


    private class ZichaListAdapter extends SFBaseAdapter<ZichaListBean.DataBean.ZichaItemBean> {

        /**
         * @param data    用于展示的列表数据
         * @param context 传入的上下文
         * @param object  引用者
         * @param exObj   此字段用于后期的一些扩展字段，一般没有效果
         */
        public ZichaListAdapter(List<ZichaListBean.DataBean.ZichaItemBean> data, Context context, Object object, Object exObj) {
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
            listItem.setData((ZichaListBean.DataBean.ZichaItemBean) getItem(position));
            return listItem;
        }
    }


}
