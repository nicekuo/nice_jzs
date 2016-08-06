package nice.com.jzs.ui.setting;

import android.view.View;
import android.widget.TextView;

import nice.com.jzs.R;
import nice.com.jzs.background.AppInfo;
import nice.com.jzs.core.AbstractActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by nice on 16/4/22.
 */


@EActivity(R.layout.activity_about_jiche)
public class ActivityAbout extends AbstractActivity {

    @ViewById(R.id.version)
    TextView version;

    @ViewById(R.id.desc1)
    TextView desc1;

    @ViewById(R.id.desc2)
    TextView desc2;

    @ViewById(R.id.appinfo)
    TextView appinfo;

    @ViewById(R.id.rootView)
    View rootView;

    int clickCount = 0;


    @AfterViews
    void initView() {
        setTitleName("关于我们");
        version.setText("脊诊室   v" + AppInfo.cver_name);
        appinfo.setText(AppInfo.getAppInfoString());
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickCount<6){
                    clickCount++;
                }else {
                    appinfo.setVisibility(View.VISIBLE);
                    clickCount = 0;
                }
            }
        });
    }

    @Override
    protected void onClickBack() {
        finish();
    }
}
