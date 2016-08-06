package nice.com.jzs.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import nice.com.jzs.R;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.ui.ViewProgress;


/**
 * Created by BaoLongxiang on 2016/2/18.
 * 登陆
 */
@EActivity(R.layout.activity_register_born)
public class ActivityRegisterBorn extends AbstractActivity {

    @ViewById(R.id.id_btn_login)
    TextView idBtnLogin;

    @ViewById(R.id.edit_view)
    EditText editView;


    @ViewById(R.id.date)
    DatePicker datePicker;

    @ViewById(R.id.view_progress)
    ViewProgress view_progress;

    private String dateStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @AfterViews
    void initView() {


        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.icon_select_true);
        images.add(R.drawable.icon_select_true);
        images.add(R.drawable.icon_select_true);
        images.add(R.drawable.icon_select_true);
        images.add(R.drawable.icon_select_true);
        images.add(R.drawable.icon_circle_true);
        view_progress.setImages(images);

        titleView.mTitle.setText("设置昵称");
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int monthOfYear = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        dateStr = year + "-" + monthOfYear + "-" + dayOfMonth;
        editView.setText(dateStr);
        datePicker.init(year, monthOfYear, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                dateStr = i + "-" + i1 + "-" + i2;
                editView.setText(dateStr);
            }
        });
    }


    @Click({R.id.id_btn_login})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_btn_login://登陆按钮

                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    protected void onClickBack() {
        finish();
    }


}
