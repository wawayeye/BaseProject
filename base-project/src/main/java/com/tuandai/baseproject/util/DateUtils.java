package com.tuandai.baseproject.util;

import java.util.Calendar;

public class DateUtils {
    public static String getDateString(String string_time) {
        if (string_time != null && !string_time.contains("-") && !string_time.equals("") && !string_time.equals("NaN")) {
            Long time = Long.parseLong(string_time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(time);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);//24小时制
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);
            return year + "-" + (month + 1) + "-" + day + " "
                    + hour + ":" + minute + ":" + second;
        }
        return string_time;
    }

    public static String getM2Date(String string_time) {
        if (string_time != null && !string_time.equals("") && !string_time.equals("NaN")) {
            Long second = Long.parseLong(string_time);
            long hours = second / 3600;//转换小时数
            second = second % 3600;//剩余秒数
            long minutes = second / 60;//转换分钟
            second = second % 60;//剩余秒数
            return hours + "小时" + minutes + "分钟" + second + "秒";
        }
        return null;
    }
}
