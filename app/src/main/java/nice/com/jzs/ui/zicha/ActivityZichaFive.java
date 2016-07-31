package nice.com.jzs.ui.zicha;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import nice.com.jzs.R;
import nice.com.jzs.camera.ActivityCapture;
import nice.com.jzs.core.AbstractActivity;

/**
 * Created by admin on 2016/7/31.
 */
@EActivity(R.layout.activity_zicha_one)
public class ActivityZichaFive extends AbstractActivity {


    @ViewById(R.id.image)
    ImageView image;
    @ViewById(R.id.tips)
    TextView tips;
    @ViewById(R.id.ok)
    TextView ok;


    @AfterViews
    void initView() {
        setTitleName("脊柱自查");
        image.setImageResource(R.drawable.img_zicha_5);
        tips.setText(getResources().getString(R.string.zicha_five));
        ok.setText(getResources().getString(R.string.zicha_three_ok_tips));
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityZichaFive.this,ActivityCapture.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onClickBack() {
        finish();
    }

}
