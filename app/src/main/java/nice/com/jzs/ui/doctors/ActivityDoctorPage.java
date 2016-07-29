package nice.com.jzs.ui.doctors;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import nice.com.jzs.R;
import nice.com.jzs.background.RequestAPI;
import nice.com.jzs.core.AbstractActivity;
import nice.com.jzs.ui.main.ViewHomeTitle;
import nice.com.nice_library.bean.BaseBean;
import nice.com.nice_library.widget.image.SFImageView;

/**
 * Created by admin on 2016/7/26.
 */
@EActivity(R.layout.activity_doctor_page)
public class ActivityDoctorPage extends AbstractActivity {

    @ViewById(R.id.avatar)
    SFImageView avatar;
    @ViewById(R.id.hospital)
    TextView hospital;
    @ViewById(R.id.title)
    TextView title;
    @ViewById(R.id.follow_member_count)
    TextView followMemberCount;
    @ViewById(R.id.consultation_times)
    TextView consultationTimes;
    @ViewById(R.id.publish_article_num)
    TextView publishArticleNum;
    @ViewById(R.id.article_about)
    LinearLayout articleAbout;
    @ViewById(R.id.doctor_introduce)
    TextView doctorIntroduce;
    @ViewById(R.id.visit_time)
    TextView visitTime;
    @ViewById(R.id.doctor_more)
    LinearLayout doctorMore;
    @ViewById(R.id.doctor_info)
    LinearLayout doctorInfo;
    @ViewById(R.id.container)
    LinearLayout container;

    @AfterViews
    void init() {
        setTitleViewBackgroundColor(Color.parseColor("#545D70"));
        getData();
        visitTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityDoctorVisitTime_.intent(ActivityDoctorPage.this).start();
            }
        });
    }

    private void getData() {
        Map<String, String> params = new HashMap<>();
        new NiceAsyncTask(false) {
            @Override
            public void loadSuccess(BaseBean bean) {
                DoctorPageBean pageBean = (DoctorPageBean) bean;
                if (pageBean != null) {
                    updateView(pageBean);
                }
            }

            @Override
            public void exception() {

            }
        }.post(true, RequestAPI.API_JZB_DOCTORS_PAGE, params, DoctorPageBean.class);
    }

    private void updateView(DoctorPageBean pageBean) {
        if (pageBean.getData() == null) {
            return;
        }

        if (pageBean.getData().getDoctor_info() != null) {
            DoctorPageBean.DataBean.DoctorInfoBean doctorInfoBean = pageBean.getData().getDoctor_info();
            setTitleName(doctorInfoBean.getName());
            avatar.SFSetImageUrl(doctorInfoBean.getAvatar());
            hospital.setText(doctorInfoBean.getHospital());
            title.setText(doctorInfoBean.getTitle());
            followMemberCount.setText(doctorInfoBean.getFollow_member_num() + "人" + "\n" + "关注");
            publishArticleNum.setText(doctorInfoBean.getPublish_article_num() + "次" + "\n" + "咨询");
            consultationTimes.setText(doctorInfoBean.getConsultation_times() + "篇" + "\n" + "文章");
        }

        if (pageBean.getData().getAbout_article() != null && pageBean.getData().getAbout_article().getArticle_list() != null) {
            DoctorPageBean.DataBean.AboutArticleBean aboutArticleBean = pageBean.getData().getAbout_article();
            ViewHomeTitle viewHomeTitle = new ViewHomeTitle(ActivityDoctorPage.this);
            viewHomeTitle.setHideArrow();
            viewHomeTitle.setData(R.drawable.icon_news, aboutArticleBean.getTitle(), null);
            container.addView(viewHomeTitle);
            for (DoctorPageBean.DataBean.AboutArticleBean.ArticleListBean listBean : pageBean.getData().getAbout_article().getArticle_list()) {
                ViewDoctorPageArticleItem articleItem = new ViewDoctorPageArticleItem(ActivityDoctorPage.this);
                articleItem.setData(listBean);
                container.addView(articleItem);
            }
        }

        if (pageBean.getData().getPublish_paper() != null && pageBean.getData().getPublish_paper().getPaper_list() != null) {
            DoctorPageBean.DataBean.PublishPaperBean publishPaperBean = pageBean.getData().getPublish_paper();
            ViewHomeTitle viewHomeTitle = new ViewHomeTitle(ActivityDoctorPage.this);
            viewHomeTitle.setHideArrow();
            viewHomeTitle.setData(R.drawable.icon_news, publishPaperBean.getTitle(), null);
            container.addView(viewHomeTitle);
            for (DoctorPageBean.DataBean.PublishPaperBean.PaperListBean listBean : pageBean.getData().getPublish_paper().getPaper_list()) {
                ViewDoctorPagePublishPaperItem pagePublishPaperItem = new ViewDoctorPagePublishPaperItem(ActivityDoctorPage.this);
                pagePublishPaperItem.setData(listBean);
                container.addView(pagePublishPaperItem);
            }
        }


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
