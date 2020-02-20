package com.zdds.facades.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 
 * 
 * @author 李亚廷
 * @Date 13:13 2020/1/18
 * @since JDK 11
 */
public class DateUtil {


    private static SimpleDateFormat YMDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 日期转年月日时分秒
     * @param date
     * @return
     */
    public static String YMDHMSdateToString(Date date){
        if(date != null){
            return YMDHMS.format(date);
        }else{
            return "";
        }
    }
}
