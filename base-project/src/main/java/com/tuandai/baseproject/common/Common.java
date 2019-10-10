package com.tuandai.baseproject.common;

public class Common {
    //服务器上jaas目录
    public static String JAAS_CONF_PATH = "/opt/keytabs/old_kafka_jaas.conf";

    //状态码
    public static Integer SUCCESS_CODE =1000;
    public static String SUCCESS_MESSAGE ="操作成功";

    public static Integer NO_USER_ID_CODE =1001;
    public static String NO_USER_ID_MESSAGE ="userid 不能为空";

    public static Integer NO_USER_PHONE_CODE =1002;
    public static String NO_USER_PHONE_MESSAGE ="手机号不能为空";

    public static Integer NO_USER_WHITE_CODE =1003;
    public static String NO_USER_WHITE_MESSAGE ="用户ip不在白名单内";

    public static Integer NO_USER_TOPIC_CODE =1004;
    public static String NO_USER_TOPIC_MESSAGE ="用户ip不在指定topic内";

    public static Integer NO_USER_SIGN_CODE =1005;
    public static String NO_USER_SIGN_MESSAGE ="用户鉴权失败";

    public static Integer NO_ORDER_TYPE_VERSION_CODE =1006;
    public static String NO_ORDER_TYPE_VERSION_MESSAGE ="传输数据（order_no,type,record_version）不能为空";

    public static Integer ERROR_CODE =9999;
    public static String ERROR_MESSAGE ="服务器内部错误";

}
