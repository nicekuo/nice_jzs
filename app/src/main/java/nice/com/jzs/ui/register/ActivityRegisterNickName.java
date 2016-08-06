package nice.com.jzs.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
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
@EActivity(R.layout.activity_register_nick_name)
public class ActivityRegisterNickName extends AbstractActivity {

    @ViewById(R.id.id_btn_login)
    TextView idBtnLogin;

    @ViewById(R.id.view_progress)
    ViewProgress view_progress;

    @ViewById(R.id.name)
    EditText name;


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
                tryRegisterName();
                break;
        }
    }

    private void tryRegisterName() {
        if (TextUtils.isEmpty(name.getText().toString())){
            ToastUtil.showToastMessage(ActivityRegisterNickName.this,"请输入昵称");
            return;
        }
        Map<String,String> map =new HashMap<>();
        map.put("nick_name",name.getText().toString());
        new NiceAsyncTask(false){

            @Override
            public void loadSuccess(BaseBean bean) {
                if (bean.result !=0){
                    ToastUtil.showToastMessage(ActivityRegisterNickName.this,bean.error_info);
                }else {
                    ActivityRegisterGender_.intent(ActivityRegisterNickName.this).start();
                }
            }

            @Override
            public void exception() {

            }
        }.post(RequestAPI.API_JZB_REGISTER_NICKNAME,map,BaseBean.class);
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
