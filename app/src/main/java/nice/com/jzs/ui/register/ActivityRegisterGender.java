package nice.com.jzs.ui.register;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nice.com.jzs.R;
import nice.com.jzs.background.RequestAPI;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.ui.ViewProgress;
import nice.com.nice_library.bean.BaseBean;
import nice.com.nice_library.util.ToastUtil;


/**
 * Created by BaoLongxiang on 2016/2/18.
 * 登陆
 */
@EActivity(R.layout.activity_register_gender)
public class ActivityRegisterGender extends AbstractActivity {

    @ViewById(R.id.id_btn_login)
    TextView idBtnLogin;

    @ViewById(R.id.man)
    TextView man;
    @ViewById(R.id.woman)
    TextView woman;

    @ViewById(R.id.view_progress)
    ViewProgress view_progress;

//    1为男 0为女
    private int select_int = 1;

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
        images.add(R.drawable.icon_circle_true);
        images.add(R.drawable.icon_circle_false);
        view_progress.setImages(images);
        selectMan();
        titleView.mTitle.setText("设置性别");
    }


    @Click({R.id.id_btn_login,R.id.man,R.id.woman})
    void onClick(View view) {
        Drawable drawable = null;
        switch (view.getId()) {
            case R.id.id_btn_login://登陆按钮
                tryRegisterGender();
                break;
            case R.id.man:
                selectMan();
                break;
            case R.id.woman:
                selectWoman();
                break;
        }
    }

    private void tryRegisterGender() {
        Map<String,String> map =new HashMap<>();
        map.put("gender",select_int+"");
        new NiceAsyncTask(false){

            @Override
            public void loadSuccess(BaseBean bean) {
                if (bean.result !=0){
                    ToastUtil.showToastMessage(ActivityRegisterGender.this,bean.error_info);
                }else {
                    ActivityRegisterBorn_.intent(ActivityRegisterGender.this).start();
                }
            }

            @Override
            public void exception() {

            }
        }.post(RequestAPI.API_JZB_REGISTER_GENDER,map,BaseBean.class);
    }

    private void selectMan() {
        Drawable drawable;
        select_int = 1;
        man.setTextColor(getResources().getColor(R.color.blue));
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = getResources().getDrawable(R.drawable.icon_gender_man_true,null);
        }else {
             drawable = getResources().getDrawable(R.drawable.icon_gender_man_true);
        }
        drawable.setBounds(0, 0, 130, 130);
        man.setCompoundDrawables(null,drawable,null,null);

        woman.setTextColor(getResources().getColor(R.color.text_999999));
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = getResources().getDrawable(R.drawable.icon_gender_women,null);
        }else {
            drawable = getResources().getDrawable(R.drawable.icon_gender_women);
        }
        drawable.setBounds(0, 0, 130, 130);
        woman.setCompoundDrawables(null,drawable,null,null);
    }

    private void selectWoman() {
        Drawable drawable;
        select_int = 0;
        woman.setTextColor(getResources().getColor(R.color.blue));
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = getResources().getDrawable(R.drawable.icon_gender_woman_true,null);
        }else {
            drawable = getResources().getDrawable(R.drawable.icon_gender_woman_true);
        }
        drawable.setBounds(0, 0, 130, 130);
        woman.setCompoundDrawables(null,drawable,null,null);

        man.setTextColor(getResources().getColor(R.color.text_999999));
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = getResources().getDrawable(R.drawable.icon_gender_man,null);
        }else {
            drawable = getResources().getDrawable(R.drawable.icon_gender_man);
        }
        drawable.setBounds(0, 0, 130, 130);
        man.setCompoundDrawables(null,drawable,null,null);
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
