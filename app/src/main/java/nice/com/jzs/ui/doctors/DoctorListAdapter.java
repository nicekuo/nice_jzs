package nice.com.jzs.ui.doctors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import nice.com.nice_library.adapter.SFBaseAdapter;

import java.util.List;

/**
 * Created by ${nice} on ${2016年04月29日14:09:09}.
 */
public class DoctorListAdapter extends SFBaseAdapter<DoctorItemBean> {
    /**
     * @param data    用于展示的列表数据
     * @param context 传入的上下文
     * @param object  引用者
     * @param exObj   此字段用于后期的一些扩展字段，一般没有效果
     */
    public DoctorListAdapter(List<DoctorItemBean> data, Context context, Object object, Object exObj) {
        super(data, context, object, exObj);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDoctorListItem doctorListItem = null;
        if (convertView == null){
            doctorListItem = new ViewDoctorListItem(mContext);
        }else {
            doctorListItem = (ViewDoctorListItem) convertView;
        }
        doctorListItem.setData((DoctorItemBean) getItem(position));
        return doctorListItem;
    }
}
