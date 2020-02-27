package com.zdds.core.util;

import org.slf4j.LoggerFactory;

import java.util.Locale;

/**
 * 
 * 
 * 
 * @author 李亚廷
 * @Date 9:34 2019/5/14
 * @since JDK 1.8
 */

public class LogUtil
{


	/**
	 * 打印信息日志消息
	 */
	public static void info(final String msg)
	{
		//        if (ConfigurationUtil.getGlobalConfig().isLogEnable()) {
		LoggerFactory.getLogger(getTag()).info(buildMessage(msg));
		//        }
	}

	/**
	 * 打印警告日志消息
	 */
	public static void warn(final String msg)
	{
		//        if (ConfigurationUtil.getGlobalConfig().isLogEnable()) {
		LoggerFactory.getLogger(getTag()).warn(buildMessage(msg));
		//        }
	}

	public static void warn(final String msg, final Throwable throwable)
	{
		//        if (ConfigurationUtil.getGlobalConfig().isLogEnable()) {
		LoggerFactory.getLogger(getTag()).warn(buildMessage(msg), throwable);
		//        }
	}

	/**
	 * 打印错误日志消息
	 */
	public static void error(final String msg, final Throwable throwable)
	{
		/* 错误信息保留 */
		LoggerFactory.getLogger(getTag()).error(buildMessage(msg), throwable);
	}

	public static void error(final String msg)
	{
		/* 错误信息保留 */
		LoggerFactory.getLogger(getTag()).error(buildMessage(msg));
	}


	private static String buildMessage(final String msg)
	{
		final StackTraceElement[] trace = new Throwable().fillInStackTrace().getStackTrace();
		//        String caller = "";
		String className = "";
		int lineNumber = 0;
		for (int i = 2; i < trace.length; i++)
		{
			final Class clazz = trace[i].getClass();
			if (!clazz.equals(LogUtil.class))
			{
				//                caller = trace[i].getMethodName();
				className = trace[i].getClassName();
				lineNumber = trace[i].getLineNumber();
				break;
			}
		}
		return String.format(Locale.US, "[%d] (%s:%d): %s ", Thread.currentThread().getId(), className, lineNumber, msg);
	}

	private static String getTag()
	{
		final StackTraceElement[] trace = new Throwable().fillInStackTrace().getStackTrace();
		String callingClass = "";
		for (int i = 2; i < trace.length; i++)
		{
			final Class clazz = trace[i].getClass();
			if (!clazz.equals(LogUtil.class))
			{
				callingClass = trace[i].getClassName();
				callingClass = callingClass.substring(callingClass.lastIndexOf('.') + 1);
				break;
			}
		}
		return callingClass;
	}
}
