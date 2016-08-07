package nice.com.jzs.ui.zicha;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.Map;

import nice.com.jzs.R;
import nice.com.jzs.background.AppInfo;
import nice.com.jzs.background.RequestAPI;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.ui.doctors.DoctorItemBean;
import nice.com.jzs.ui.main.ViewHomeDoctorItem;
import nice.com.nice_library.bean.BaseBean;

/**
 * Created by admin on 2016/8/7.
 */
@EActivity(R.layout.activity_zicha_result)
public class ActivityZichaResult extends AbstractActivity {

    @Extra
    String url;
    @Extra
    String degree;

    @ViewById(R.id.diagnosed)
    TextView diagnosed;
    @ViewById(R.id.degree)
    TextView degreeView;
    @ViewById(R.id.tips)
    TextView tips;
    @ViewById(R.id.content_container)
    LinearLayout contentContainer;


    @AfterViews
    void initView() {
        addZichaRecord();
    }

    private void addZichaRecord() {
        Map<String, String> map = new HashMap<>();
        map.put("url", url);
        map.put("degree", degree + "");
        new NiceAsyncTask(false) {

            @Override
            public void loadSuccess(BaseBean bean) {
                ZichaResultBean resultBean = (ZichaResultBean) bean;
                if (resultBean.getData() != null) {
                    updateView(resultBean);
                }

            }

            @Override
            public void exception() {

            }
        }.post(RequestAPI.API_JZB_ADD_ZICHA, map, ZichaResultBean.class);
    }

    private void updateView(ZichaResultBean resultBean) {

        degreeView.setText(resultBean.getData().getDegree() + "°");
        tips.setText(resultBean.getData().getTips());
        diagnosed.setText(resultBean.getData().getDiagnosed());

        contentContainer.removeAllViews();
        LinearLayout linearLayout = new LinearLayout(ActivityZichaResult.this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        int width = AppInfo.width;
        if (resultBean.getData().getDoctor_list() != null && resultBean.getData().getDoctor_list().size() > 0) {
            for (DoctorItemBean itemBean : resultBean.getData().getDoctor_list()) {
                ViewHomeDoctorItem item = new ViewHomeDoctorItem(ActivityZichaResult.this);
                item.setData(itemBean);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width / 3, ViewGroup.LayoutParams.WRAP_CONTENT);
                linearLayout.addView(item, params);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 500);
            params.bottomMargin = 200;
            contentContainer.addView(linearLayout, params);
        }
    }

    @Override
    protected void onClickBack() {
        finish();
    }

}
