package com.zdds.core.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *
 *
 * @author 李亚廷
 * @Date 16:13 2020/2/26
 * @since JDK 11
 */
public class DateTransferUtil {


    private static ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
    private static ThreadLocal<DateFormat> df8c =new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };
    private static ThreadLocal<DateFormat> dtf =new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    private static ThreadLocal<DateFormat> dtfs =new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        }
    };

    public static String date2String(final Date date)
    {
        if (date == null )
        {
            return null;
        }
        return df.get().format(date);
    }

    public static Date string2Date(final String str)
    {
        if (str == null || "".equals(str))
        {
            return null;
        }
        try
        {
            return df.get().parse(str);
        }
        catch (final ParseException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static String datetime2String(final Date date)
    {
        if (date == null)
        {
            return null;
        }

        return dtf.get().format(date);
    }

    public static Date string2Datetime(final String str)
    {
        if (str == null)
        {
            return null;
        }
        try
        {
            return dtf.get().parse(str);
        }
        catch (final ParseException e)
        {
            e.printStackTrace();
            try {
                return dtfs.get().parse(str);
            }catch (final ParseException e2) {
                return null;
            }
        }
    }

    public static String datet2String8c(final Date date)
    {
        if (date == null)
        {
            return null;
        }

        return df8c.get().format(date);
    }

    public static Date string2Date8c(final String str)
    {
        if (str == null)
        {
            return null;
        }
        try
        {
            return df8c.get().parse(str);
        }
        catch (final ParseException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static Date string2Date(final String str, final String format)
    {
        if (str == null)
        {
            return null;
        }
        try
        {
            if (format == null)
            {
                return string2Date(str);
            }
            else
            {
                final DateFormat mydf = new SimpleDateFormat(format);
                return mydf.parse(str);
            }
        }
        catch (final ParseException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static String date2String(final Date date, final String format)
    {
        if (date == null)
        {
            return null;
        }
        try
        {
            if (format == null)
            {
                return date2String(date);
            }
            else
            {
                final DateFormat mydf = new SimpleDateFormat(format);
                return mydf.format(date);
            }
        }
        catch (final Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
