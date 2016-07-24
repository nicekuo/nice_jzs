package nice.com.jzs.ui.doctors;

import nice.com.nice_library.bean.BaseBean;

import java.util.List;

/**
 * Created by admin on 2016/7/20.
 */
public class DoctorListBean extends BaseBean {


    /**
     * isLastPage : false
     * isFirstPage : true
     * size_in_one_page : 20
     * size_total : 90
     * page_temp : 2
     * pageTotal : 5
     * doctor_list : [{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"},{"avatar":"http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg","name":"赵一鸣","title":"主任医师","hospital":"北京协和医院","doctor_id":"123456"},{"avatar":"http://img.deikang.com/images/201310/21/1382347108_96245200.jpg","name":"于佳佳","title":"医师","hospital":"宣武医院","doctor_id":"123456"},{"avatar":"http://img.taopic.com/uploads/allimg/140704/240455-140F406352283.jpg","name":"王蕾","title":"主治医师","hospital":"中国医科大学附属医院","doctor_id":"123456"}]
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private boolean isLastPage;
        private boolean isFirstPage;
        private int size_in_one_page;
        private int size_total;
        private int page_temp;
        private int pageTotal;
        /**
         * avatar : http://money.gucheng.com/UploadFiles_6503/201508/2015082523214635.jpg
         * name : 赵一鸣
         * title : 主任医师
         * hospital : 北京协和医院
         * doctor_id : 123456
         */

        private List<DoctorItemBean> doctor_list;

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public int getSize_in_one_page() {
            return size_in_one_page;
        }

        public void setSize_in_one_page(int size_in_one_page) {
            this.size_in_one_page = size_in_one_page;
        }

        public int getSize_total() {
            return size_total;
        }

        public void setSize_total(int size_total) {
            this.size_total = size_total;
        }

        public int getPage_temp() {
            return page_temp;
        }

        public void setPage_temp(int page_temp) {
            this.page_temp = page_temp;
        }

        public int getPageTotal() {
            return pageTotal;
        }

        public void setPageTotal(int pageTotal) {
            this.pageTotal = pageTotal;
        }

        public List<DoctorItemBean> getDoctor_list() {
            return doctor_list;
        }

        public void setDoctor_list(List<DoctorItemBean> doctor_list) {
            this.doctor_list = doctor_list;
        }

    }
}
