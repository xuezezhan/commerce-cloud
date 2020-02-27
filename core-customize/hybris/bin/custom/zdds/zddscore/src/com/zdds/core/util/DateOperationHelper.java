/**
 * DateOperationHelper.java 2015年6月19日
 * <p>
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.zdds.core.util;

import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 
 * 
 * 
 * @author 李亚廷
 * @Date 16:13 2020/2/26
 * @since JDK 11
 */
public class DateOperationHelper {
    public static Date getPreDateByDays(final Date nowDate, final int days) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - days);
        final Date startTime = calendar.getTime();
        return startTime;
    }

    public static Date getPreDateByMonth(final Date nowDate, final int months) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.MONTH, -months);
        final Date startTime = calendar.getTime();
        return startTime;
    }

    public static Date getAfterDateByMonth(final Date nowDate, final int months) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.MONTH, +months);
        final Date startTime = calendar.getTime();
        return startTime;
    }

    public static Date getAfterDateByDays(final Date nowDate, final int days) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + days);
        final Date startTime = calendar.getTime();
        return startTime;
    }

    public static Date getAfterDateByHour(final Date nowDate, final int hours) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.HOUR, +hours);
        final Date startTime = calendar.getTime();
        return startTime;
    }

    public static Date getPreDateByHour(final Date nowDate, final int hours) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.HOUR, -hours);
        final Date startTime = calendar.getTime();
        return startTime;
    }

    public static Date getPreDateByMin(final Date nowDate, final int min) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.MINUTE, -min);
        final Date startTime = calendar.getTime();
        return startTime;
    }

    public static String convert(final Date date, final String dateFormat) {
        final SimpleDateFormat sdFormat = new SimpleDateFormat(dateFormat);
        final String dateString = sdFormat.format(date);
        return dateString;
    }

    public static Date convert(final String date, final String dateFormat) {
        if (!StringUtils.isEmpty(date)) {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
            try {
                return simpleDateFormat.parse(date.replace("T", " ").replace("Z", " "));
            } catch (final Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static int compare(final String var1, final String var2, final String dateFormat) throws Exception {
        final Calendar currentTime = Calendar.getInstance();
        final Calendar compareTime = Calendar.getInstance();

        currentTime.setTime(convert(var1, dateFormat));
        compareTime.setTime(convert(var2, dateFormat));

        return currentTime.compareTo(compareTime);
    }
}
