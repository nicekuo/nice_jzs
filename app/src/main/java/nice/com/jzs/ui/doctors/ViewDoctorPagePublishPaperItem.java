package nice.com.jzs.ui.doctors;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.ViewById;

import nice.com.jzs.R;
import nice.com.nice_library.util.ToastUtil;

/**
 * Created by admin on 2016/7/27.
 */
public class ViewDoctorPagePublishPaperItem extends LinearLayout {
    private TextView title;
    private TextView time;
    private TextView magazine;
    private Context context;

    public ViewDoctorPagePublishPaperItem(Context context) {
        super(context);
        initView(context);
    }

    public ViewDoctorPagePublishPaperItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_doctor_page_publish_paper_item, this, true);
        title = (TextView) findViewById(R.id.title);
        time = (TextView) findViewById(R.id.time);
        magazine = (TextView) findViewById(R.id.magazine);
    }

    public void setData(final DoctorPageBean.DataBean.PublishPaperBean.PaperListBean bean) {
        title.setText(bean.getTitle());
        time.setText(bean.getTime());
        magazine.setText(bean.getMagazine());
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showToastMessage(context, bean.getUrl());
            }
        });
    }
}
