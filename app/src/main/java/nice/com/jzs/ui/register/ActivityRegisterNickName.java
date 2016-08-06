package nice.com.jzs.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import nice.com.jzs.R;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.ui.ViewProgress;


/**
 * Created by BaoLongxiang on 2016/2/18.
 * 登陆
 */
@EActivity(R.layout.activity_register_nick_name)
public class ActivityRegisterNickName extends AbstractActivity {

    @ViewById(R.id.id_btn_login)
    TextView idBtnLogin;

    @ViewById(R.id.view_progress)
    ViewProgress view_progress;


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
        images.add(R.drawable.icon_circle_true);
        images.add(R.drawable.icon_circle_false);
        images.add(R.drawable.icon_circle_false);
        view_progress.setImages(images);

        titleView.mTitle.setText("设置昵称");
    }


    @Click({R.id.id_btn_login})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_btn_login://登陆按钮
                ActivityRegisterGender_.intent(ActivityRegisterNickName.this).start();
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
