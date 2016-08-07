package nice.com.jzs.background;

import org.androidannotations.annotations.res.StringRes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caibing.zhang
 * @createdate 2015年1月31日 下午12:25:09
 * @Description: 请求API
 */
public class RequestAPI {

    public static final String OFFICIAL_BASE_URL = "http://192.130.02.1/";//正式访问地址。

    public static final String DEVELOP_BASE_URL = "http://www.meixinger.com/jifeng/api/";//测试访问地址。


    /*正式url*/
    public static final String API_MEMBER_LOGIN_MOBILE = "member/loginMobile";

    public static final String API_MEMBER_LOGIN_NORMAL = "member/loginNormal";

    public static final String API_ADD_CAR_TO_MY_LIST = "memberCar/addMemberCar";

    /**
     * 获取我的车的列表
     **/
    public static final String API_MY_CAR_LIST = "memberCar/findMemberCar";

    public static final String API_ORDER_DETAIL_BY_ID = "orders/getOrdersByMemberId";

    public static final String API_MEMBER_CHANGE_CAR = "memberCar/updateCurrentCar";

    public static final String API_DELETE_MY_CAR = "memberCar/delMemberCar";

    public static final String API_COUPON_GET_COUPON = "memberCoupons/getMyCoupons";

    public static final String API_ORDER_INFO = "orders/getOrderDetail";

    public static final String API_ADD_GOODS_COMMENT = "api/product/addProductComments";

    public static final String API_GET_FAVORIATE_SHOPS = "member/getFavoritesShop";

    public static final String API_CHANGE_PASSWORD = "member/setNamePwd";

    public static final String API_ADD_FAVORITE_SHOPS = "member/addFavoritesShop";

    public static final String API_DELETE_FAVORITE_SHOPS = "member/delFavoritesShop";

    public static final String API_GET_MINE_ALL = "member/getMineAll";

    public static final String API_CHECK_ORDER = "orders/checkOrder";

    public static final String API_GET_SHOP_SERVICES = "orders/getServicesProduct";

    public static final String API_ORDER_CREATE = "orders/save";

    public static final String API_ORDE_PAY = "pay";

    public static final String API_EXCHANGE_SERVICE_GOOD = "api/product/changeProduct";

    public static final String API_ADD_SHOP_COMMENT = "shops/addShopsComments";

    public static final String API_ORDER_CANCLE = "orders/cancelOrder";

    public static final String URL_Image_Upload = "api/upload/uploadImg";

    public static final String API_MODIFY_AVATAR = "member/modifyMemberHead";

    public static final String API_MODIFY_INFO = "member/addMemberInfo";

    public static final String SMS_REQUEST = "sms/request";

    public static final String SMS_VALIDATE = "sms/validate";

    public static final String API_MEMBER_PUSH_TOKEN = "member/getPushToken";

    public static final String API_MEMBER_LOGIN_OUT = "member/loginOut";

    public static final String API_MEMBER_LOGIN_WECHAT = "weChat/loginWeChat";


    /*
    * 临时开发使用的url
    * */
    public static final String API_JZB_HOME_INDEX = "develop_home/index";
    public static final String API_JZB_NEWS_GROUP = "develop_news/group";
    public static final String API_JZB_NEWS_LIST = "develop_news/list";
    public static final String API_JZB_DOCTORS_GROUP = "develop_doctor/group";
    public static final String API_JZB_DOCTORS_LIST = "develop_doctor/list";
    public static final String API_JZB_DOCTORS_PAGE = "develop_doctor/page";
    public static final String API_JZB_DOCTORS_VISIT_TIME = "develop_doctor/visit_time";
    public static final String API_JZB_REGISTER_PHONE = "develop_register/phone";
    public static final String API_JZB_REGISTER_PASSWORD = "develop_register/password";
    public static final String API_JZB_REGISTER_NICKNAME = "develop_register/nickname";
    public static final String API_JZB_REGISTER_GENDER = "develop_register/gender";
    public static final String API_JZB_REGISTER_BORN = "develop_register/born";
    public static final String API_JZB_LOGIN_PHONE = "accounts/login.do";
    public static final String API_JZB_UPLOAD_IMG = "accounts/upload_img.do";
    public static final String API_JZB_ZICHA_LIST = "accounts/zicha_list.do";
    public static final String API_JZB_ADD_ZICHA = "accounts/add_zicha_record.do";
    public static final String API_JZB_ZICHA_DETAIL = "accounts/zicha_detail.do";


    private static List<String> needTokenURLList = Arrays.asList(API_JZB_UPLOAD_IMG, API_JZB_ZICHA_LIST, API_JZB_ADD_ZICHA
    );


    public static boolean isNeedTokenURL(String url) {
        return needTokenURLList.contains(url);
    }

    public static String getAbsoluteUrl(String relativeUrl) {
        if (JICHEApplication.getInstance().isDevelop()) {
            return RequestAPI.DEVELOP_BASE_URL + relativeUrl;
        } else {
            return RequestAPI.OFFICIAL_BASE_URL + relativeUrl;
        }
    }

    public static Map<String, String> configRequestParams(Map<String, String> params) {
        if (params == null) {
            params = new HashMap<>();
        }
//        params.put("app", AppInfo.APP_NAME);
//        params.put("via", AppInfo.via);
//        params.put("cver", AppInfo.cver_name);
//        params.put("ver", AppInfo.ver);
//        params.put("version_code", AppInfo.cver_code);
//        params.put("uuid", AppInfo.uuid);
//        params.put("channel_id", AppInfo.qudao_code);
        return params;
    }


}
