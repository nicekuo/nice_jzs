package nice.com.jzs.ui.zicha;

import android.os.Bundle;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import butterknife.BindView;
import butterknife.ButterKnife;
import nice.com.jzs.R;
import nice.com.jzs.core.AbstractActivity;

/**
 * Created by admin on 2016/8/7.
 */
@EActivity(R.layout.activity_zicha_result)
public class ActivityZichaResult extends AbstractActivity {

    @Extra
    String url;

    @Extra
    String degree;


    @ViewById(R.id.url)
    TextView urlView;
    @ViewById(R.id.degree)
    TextView degreeView;


    @AfterViews
    void initView() {
        urlView.setText(url);
        degreeView.setText(degree);
    }


    @Override
    protected void onClickBack() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
