package com.picc.prpins.quote.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 功能：对日期操作的公共方法类
 *
 */
public class DateUtil {

	/***
	 * 格式化日期的方法
	 *
	 * @param date
	 *            带格式化的日期
	 * @param pattern
	 *            格式化的表达式 比如 yyyy-MM-dd
	 * @return 格式化后的字符串
	 */
	public static String formatDate(Date date, String pattern) {
		// 建立日期FORMAT的实例
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}

	/***
	 * 格式化日期的方法
	 *
	 * @param date
	 *            带格式化的日期，默认为yyyy-MM-dd
	 * @return 格式化后的字符串
	 */
	public static String formatDate(Date date) {
		return formatDate(date, "yyyy-MM-dd");
	}

	/**
	 * 利用传入的日期，返回上一个月当天的日期对象
	 *
	 * @param current
	 *            ：当前日期对象
	 * @return 上一个月的当天的日期对象
	 */
	public static Date getPreviousMonth(Date current) {
		if (current.getMonth() != 1) {
			// 如果不是一月份，则直接减去一天
			return new Date(current.getYear(), current.getMonth() - 1,
					current.getDate());
		} else {
			// 如果是一月份，则需要在年上减去一天，月变为12
			return new Date(current.getYear() - 1, 12, current.getDate());
		}
	}

	/**
	 * 利用传入的日期，返回上一个月当天的日期对象
	 *
	 * @param current
	 *            ：当前日期对象
	 * @return 上一个月的当天的日期对象
	 */
	public static Date getNextMonth(Date current) {
		if (current.getMonth() != 12) {
			// 如果不是一月份，则直接减去一天
			return new Date(current.getYear(), current.getMonth() + 1,
					current.getDate());
		} else {
			// 如果是一月份，则需要在年上减去一天，月变为12
			return new Date(current.getYear() + 1, 0, current.getDate());
		}
	}

	/**
	 * 利用传入的日期,返回下个月最后一天的日期
	 * guoyonggang
	 * @return
	 */
	public static Date getNextMonthEnd(Date current) {
		Calendar lastDate = Calendar.getInstance();
		lastDate.setTime(current);
		lastDate.add(Calendar.MONTH, 1);// 加一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		Date date=lastDate.getTime();
		return date;
	}

	/**
	 * 利用传入的日期,返回120天后的日期
	 */
	public static Date getNextsMonthEnd(Date current) {
		Calendar lastDate = Calendar.getInstance();
		lastDate.setTime(current);
		lastDate.add(Calendar.MONTH, 4);// 加一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		Date date=lastDate.getTime();
		return date;
	}


	/** 利用传入日期，返回一个上个月日期的yyyyMM的String表达式 */
	public static String getPreviousMonths(Date current) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		return sdf.format(getPreviousMonth(current));
	}

	/***
	 * 获取传入日期上一年的日期对象
	 *
	 * @param date
	 *            传入的日期对象
	 * @return 上一年的日期对象
	 */
	public static Date getPreviousYear(Date date) {
		return new Date(date.getYear() - 1, date.getMonth(), date.getDate());
	}

	/***
	 * 获取传入日期下一年的日期对象
	 *
	 * @param date
	 *            传入的日期对象
	 * @return 下一年的日期对象
	 */
	public static Date getNextYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, 1);
		return calendar.getTime();
	}

	/***
	 * 获取传入日期下n年的日期对象
	 *
	 * @param date
	 *            传入的日期对象
	 * @return 下n年的日期对象
	 */
	public static Date getNextNYear(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, n);
		return calendar.getTime();
	}

	/***
	 * 计算传入日期的往后顺延N天以后的日期对象
	 *
	 * @param date
	 *            传入的日期对象
	 * @param n
	 *            往后顺延的天数
	 * @return 顺延后的日期对象
	 */
	public static Date getPreviousNDate(Date date, long n) {
		long time = date.getTime();
		// 用毫秒数来计算新的日期
		time = time - n * 24 * 60 * 60 * 1000;
		return new Date(time);
	}

	/***
	 * 计算传入日期的往前推算N天的日期对象
	 *
	 * @param date
	 *            传入的日期对象
	 * @param n
	 *            往后顺延的天数
	 * @return 往前推算后的日期对象
	 */
	public static Date getNextNDate(Date date, long n) {
		long time = date.getTime();
		// 用毫秒数来计算新的日期
		time = time + n * 24 * 60 * 60 * 1000;
		return new Date(time);
	}

	/***
	 * 计算传入日期的前一天
	 *
	 * @param date
	 *            传入日期
	 * @return 传入日期的前一天的日期对象
	 */
	public static Date getPreviousDate(Date date) {
		return getPreviousNDate(date, 1);
	}

	/***
	 * 计算传入日期的后一天
	 *
	 * @param date
	 *            传入日期
	 * @return 传入日期的后一天的日期对象
	 */
	public static Date getNextDate(Date date) {
		return getNextNDate(date, 1);
	}

	/**
	 * 日期转换成字符串
	 */
	public static String dateToStr(Date date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String str = format.format(date);
		return str;
	}

	/**
	 * 字符串转换成日期
	 */
	public static Date strToDate(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 根据传入的日期计算此日期与下一年该日相差的天数
	 *
	 * @param startDate
	 *            起始日期
	 * @return 天数区间
	 */
	public static int getDaysCountForYear(Date startDate) {
		// 获取传入日期下一年的日期对象
		Date nextYear = getNextYear(startDate);
		// 计算天数
		return getDaysCount(startDate, nextYear);
	}

	/***
	 * 根据起始日期、终止日期计算天数
	 *
	 * @param startDate
	 *            起始日期
	 * @param endDate
	 *            终止日期
	 * @return 天数区间
	 */
	public static int getDaysCount(Date startDate, Date endDate) {
		return getDaysCount(startDate, 0, endDate, 0);
	}

	/***
	 * 根据年数返回所包含的天数
	 *
	 * @param year
	 *            年数
	 * @return 该年所包含的天数
	 */
	public static int getDaysFromYear(int year) {
		// 判断是平年还是闰年
		if ((year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0)) {
			return 366;
		} else
			return 365;

	}

	/***
	 * 根据起始日期、起始时间、终止日期、终止时间计算天数
	 *
	 * @param startDate
	 *            起始日期
	 * @param startHour
	 *            起始小时
	 * @param endDate
	 *            终止日期
	 * @param endHour
	 *            终止小时
	 * @return 天数区间
	 */
	public static int getDaysCount(Date startDate, int startHour, Date endDate,
								   int endHour) {
		// 根据起始日期计算起始的毫秒
		long startTime = startDate.getTime();
		// 根据终止日期计算终止的毫秒
		long endTime = endDate.getTime();
		// 通过起始毫秒和终止毫秒的差值，计算天数
		int dayCount = (int) ((endTime - startTime) / (24 * 60 * 60 * 1000) + 1);

		if (endHour <= startHour) {
			if (startHour == 24 && endHour == 0) {
				dayCount = dayCount - 2;
			} else {
				dayCount = dayCount - 1;
			}
		}
		return dayCount;

	}

	/***
	 * 根据起始日期、终止日期计算月数
	 *
	 * @param startDate
	 *            起始日期
	 * @param endDate
	 *            终止日期
	 * @return 天数区间
	 */
	public static int getMonthsCount(Date startDate, Date endDate) {
		return getMonthsCount(startDate, 0, endDate, 0);
	}

	/***
	 * 根据起始日期、起始时间、终止日期、终止时间计算天数
	 *
	 * @param startDate
	 *            起始日期
	 * @param startHour
	 *            起始小时
	 * @param endDate
	 *            终止日期
	 * @param endHour
	 *            终止小时
	 * @return 天数区间
	 */
	public static int getMonthsCount(Date startDate, int startHour,
									 Date endDate, int endHour) {
		// 年份差
		int yearDiff = endDate.getYear() - startDate.getYear();
		// 月份差
		int monthDiff = endDate.getMonth() - startDate.getMonth();
		// 总的月数量
		int monthCount = monthDiff + yearDiff * 12;
		// 天数差
		long dayDiff = endDate.getDate() - startDate.getDate();
		// 不足一个月按一个月计算
		if (dayDiff > 0 || (dayDiff == 0 && endHour > startHour)) {
			monthCount = monthCount + 1;
		}

		return monthCount;

	}
	/***
	 * RYANGQH2013031501 条款费率调整
	 * 根据起始日期、起始时间、终止日期、终止时间计算已承保整数月
	 *
	 * @param startDate
	 *            起始日期
	 * @param startHour
	 *            起始小时
	 * @param endDate
	 *            终止日期
	 * @param endHour
	 *            终止小时
	 * @return 天数区间
	 * @author liusaisai  20130403
	 */
	public static int getMonthsFull(Date startDate, int startHour,
									Date endDate, int endHour) {
		// 年份差
		int yearDiff = endDate.getYear() - startDate.getYear();
		// 月份差
		int monthDiff = endDate.getMonth() - startDate.getMonth();
		// 总的月数量
		int monthCount = monthDiff + yearDiff * 12;
		// 天数差
		long dayDiff = endDate.getDate() - startDate.getDate();
		int hourDiff = endHour - startHour;
		if(dayDiff < -1){
			monthCount --;
		}else if(dayDiff == -1 && hourDiff < 24){
			monthCount --;
		}else if(dayDiff == 0 && hourDiff < 0){
			monthCount --;
		}
		return monthCount;

	}

	/***
	 * 根据起始日期、终止日期计算年数
	 *
	 * @param startDate
	 *            起始日期
	 * @param endDate
	 *            终止日期
	 * @return 天数区间
	 */
	public static int getYearsCount(Date startDate, Date endDate) {
		return getYearsCount(startDate, 0, endDate, 0);
	}

	/***
	 * 根据起始日期、起始时间、终止日期、终止时间计算天数
	 *
	 * @param startDate
	 *            起始日期
	 * @param startHour
	 *            起始小时
	 * @param endDate
	 *            终止日期
	 * @param endHour
	 *            终止小时
	 * @return 天数区间
	 */
	public static int getYearsCount(Date startDate, int startHour,
									Date endDate, int endHour) {
		int yearCount = 0;

		// 获取之间的月数
		int monthCount = getMonthsCount(startDate, startHour, endDate, endHour);

		yearCount = monthCount / 12;

		if (monthCount % 12 != 0) {
			yearCount++;
		}

		// 返回年数
		return yearCount;
	}

	/**
	 * 根据日期获取总小时数
	 *
	 * @param date
	 *            日期对象
	 * @return 总小时数
	 */
	public static int getHoursCount(Date date) {
		return getHoursCount(date, 0);
	}

	/**
	 * 根据日期和小时数，获取总小时数
	 *
	 * @param date
	 *            日期对象
	 * @param hour
	 *            小时数
	 * @return 总小时数
	 */
	public static int getHoursCount(Date date, Integer hour) {
		long hourCount = hour;
		hourCount += date.getTime() / 3600 / 1000;
		return (int) hourCount;
	}


	/***
	 * 比较两个日期的大小
	 *
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return -1 ： 开始日期小于结束日期 0 ： 开始日期等于结束日期 1 ： 开始日期大于结束日期
	 */
	public static int compareDate(Date startDate, Date endDate) {
		long startTime = startDate.getTime();
		long endTime = endDate.getTime();
		if (startTime < endTime) {
			return -1;
		}
		if (startTime == endTime) {
			return 0;
		}
		return 1;
	}

	/***
	 * 比较两个日期的大小
	 *
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return -1 ： 开始日期小于结束日期 0 ： 开始日期等于结束日期 1 ： 开始日期大于结束日期
	 */
	public static int compareDate(String startDate, String endDate) {
		return compareDate(strToDate(startDate), strToDate(endDate));
	}

	/***
	 * 根据起始日期、起始时间、终止日期、终止时间计算月数，计算的是去掉多余天数的月数
	 *
	 * @param startDate
	 *            起始日期
	 * @param startHour
	 *            起始小时
	 * @param endDate
	 *            终止日期
	 * @param endHour
	 *            终止小时
	 * @return 期间相差的月数(去掉多余的天数)
	 */
	public static int getMinMonthsCount(Date startDate, int startHour,
										Date endDate, int endHour) {
		// 年份差
		int yearDiff = endDate.getYear() - startDate.getYear();
		// 月份差
		int monthDiff = endDate.getMonth() - startDate.getMonth();
		// 总的月数量
		int monthCount = monthDiff + yearDiff * 12;
		// 天数差
		long dayDiff = endDate.getDate() - startDate.getDate();
		if(startHour == 0 && endHour == 24){
			dayDiff += 1;
		}
		// 如果天数差小于0或者天数差等于零（并且终止小时小于起始小时），那么月数减一。
		if (dayDiff < 0 || (dayDiff == 0 && endHour < startHour)) {
			monthCount = monthCount - 1;
		}
		return monthCount;

	}

	/***
	 * 根据起始日期、起始时间、终止日期、终止时间计算天数，计算的是相差月后余下的天数
	 *
	 * @param startDate
	 *            起始日期
	 * @param startHour
	 *            起始小时
	 * @param endDate
	 *            终止日期
	 * @param endHour
	 *            终止小时
	 * @return 余下的天数
	 *
	 */
	public static int getOtherDayCount(Date startDate, int startHour,
									   Date endDate, int endHour) {
		// 相差的天数
		int dayCount = 0;
		// 时间变量
		long newStartTime = 0;
		// 终保日期getTime变量
		long endTime = 0;
		// 计算日相差
		int dayDiff = endDate.getDate() - startDate.getDate();
		// 如果日相差等于0，那endHour > startHour,那么返回一天，如：2010-10-10：02到2010-10-10:09
		if (dayDiff == 0) {
			if (endHour > startHour) {
				return 1;
			}
			// 如果日相差小于0
		} else if (dayDiff < 0) {
			//Q2013-0218 JAW保费计算不正确 mod by liusaisai 20131203 begin
			if(dayDiff == -1 && endHour == 24 && startHour == 0){
				dayCount = 0;
			}else
				//Q2013-0218 JAW保费计算不正确 mod by liusaisai 20131203 end
				// 如果startHour < endHour，如：2010-09-18:02------2010-10-10:08
				if (startHour < endHour) {
					Date newStartDate = new Date(endDate.getYear(),
							endDate.getMonth() - 1, startDate.getDate());
					newStartTime = newStartDate.getTime();
					endTime = endDate.getTime();
					dayCount = (int) ((endTime - newStartTime)
							/ (24 * 60 * 60 * 1000) + 1);
					// 如果startHour = endHour，如：2010-09-18:02------2010-10-10:02
				} else if (startHour == endHour) {
					Date newStartDate = new Date(endDate.getYear(),
							endDate.getMonth() - 1, startDate.getDate());
					newStartTime = newStartDate.getTime();
					endTime = endDate.getTime();
					dayCount = (int) ((endTime - newStartTime) / (24 * 60 * 60 * 1000));
					// 如果startHour > endHour
				} else if (startHour > endHour) {
					Date newStartDate = new Date(endDate.getYear(),
							endDate.getMonth() - 1, startDate.getDate());
					newStartTime = newStartDate.getTime();
					endTime = endDate.getTime();
					dayCount = (int) ((endTime - newStartTime)
							/ (24 * 60 * 60 * 1000) + 1);
					// 如：2010-09-18:24------2010-10-10:00
					if (startHour == 24 && endHour == 0) {
						dayCount = dayCount - 2;
						// 如：2010-09-18:14------2010-10-10:10
					} else {
						dayCount = dayCount - 1;
					}
				}
			// 日相差大于0
		} else if (dayDiff > 0) {
			//Q2013-0218 JAW保费计算不正确 mod by liusaisai 20131203 begin
			if(dayDiff == 1 && startHour == 24 && endHour == 0){
				dayCount = 0;
			}else
				//Q2013-0218 JAW保费计算不正确 mod by liusaisai 20131203 end
				// 如果startHour < endHour
				if (startHour > endHour) {
					Date newStartDate = new Date(endDate.getYear(),
							endDate.getMonth(), startDate.getDate());
					newStartTime = newStartDate.getTime();
					endTime = endDate.getTime();
					// 如：2010-10-10:08------2010-10-18:02
					dayCount = (int) ((endTime - newStartTime) / (24 * 60 * 60 * 1000));
					// 如：2010-10-10:24------2010-10-18:00
					if (startHour == 24 && endHour == 0) {
						dayCount = dayCount - 1;
					}
					// 如果startHour = endHour，如：2010-10-10:08------2010-10-18:08
				} else if (startHour == endHour) {
					Date newStartDate = new Date(endDate.getYear(),
							endDate.getMonth(), startDate.getDate());
					newStartTime = newStartDate.getTime();
					endTime = endDate.getTime();
					dayCount = (int) ((endTime - newStartTime) / (24 * 60 * 60 * 1000));
					// 如果startHour < endHour，如：2010-10-10:02------2010-10-18:08
				} else if (startHour < endHour) {
					Date newStartDate = new Date(endDate.getYear(),
							endDate.getMonth(), startDate.getDate());
					newStartTime = newStartDate.getTime();
					endTime = endDate.getTime();
					dayCount = (int) ((endTime - newStartTime)
							/ (24 * 60 * 60 * 1000) + 1);
				}
		}
		return dayCount;
	}
	/***
	 * 格式化日期的方法
	 *
	 * @param date
	 *            带格式化的日期，默认为yyyy-MM-dd HH:mm:ss
	 * @return 格式化后的字符串
	 */
	public static String formatDate2(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}
	/***
	 * 格式化日期的方法
	 *
	 * @param date
	 *            带格式化的日期，默认为yyyy-MM
	 * @return 格式化后的字符串
	 */
	public static String formatDate3(Date date) {
		return formatDate(date, "yyyy-MM");
	}

	/**
	 * 获取小时数
	 * liuqi
	 */
	public static int getHour(int startHour,int endHour){
		int hour=0;
		if(endHour<startHour){
			hour=endHour + 24 - startHour;
		}else if((startHour==0 && endHour ==24) ||(startHour==24 && endHour ==0) ){
			hour=0;
		}else{
			hour=endHour - startHour;
		}
		return hour;
	}

	/**
	 * 获取传入日期下n年的日期对象
	 * @作者：雒乐
	 * @日期：2017-08-12
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date getNextNYearDate(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, n);
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}
	/***
	 * 计算传入日期的往前推算N-1天的日期对象(终保小时数为24时)
	 * @return 往前推算后的日期对象
	 */
	public static Date getNextNNDate(Date date, long n) {
		long time = date.getTime();
		// 用毫秒数来计算新的日期
		time = time + (n -1)* 24 * 60 * 60 * 1000;
		return new Date(time);
	}


	/**
	 * 对起保时间，获得只有[yyyy-MM-dd]的Date对象
	 * @param startTime
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getyyyyMMddDate(Date startTime){
		SimpleDateFormat sdf_long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf_short = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf_short.parse(sdf_long.format(startTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}


	/**
	 * 对起保时间，获得只有[yyyy-MM-dd]的Date对象
	 * @param startTime
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getStartDate(Date startTime){
		SimpleDateFormat sdf_long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf_short = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		try {
			startDate = sdf_short.parse(sdf_long.format(startTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return startDate;
	}


	/**
	 * 对yyyy-MM-dd HH:mm:ss终保时间，获得只有[yyyy-MM-dd]的Date对象
	 * @param endTime
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getEndDate(Date endTime) {
		SimpleDateFormat sdf_long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf_short = new SimpleDateFormat("yyyy-MM-dd");
		Date endDate = null;
		try{
			String[] endDates = sdf_long.format(endTime).split(" ");
			//如果终保时间为24点，则处理：终保日期往前推一天，终保小时为24点
			if (endDates.length > 1 && (endDates[1].substring(0, 2).equals("00") || endDates[1].substring(0, 2).equals("24"))) {
				Calendar date = Calendar.getInstance();
				date.setTime(endTime);
				// 获取前一天
				date.add(Calendar.DAY_OF_MONTH, -1);
				endDate = sdf_short.parse(sdf_long.format(date.getTime()));
			}else {
				endDate = sdf_short.parse(sdf_long.format(endTime));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return endDate;
	}

	/**
	 * 对字符串yyyy-MM-dd HH:mm:ss的终保时间，获得只有[yyyy-MM-dd]的Date对象
	 * @param endTime
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getEndDateOfString(String endTime) {
		SimpleDateFormat sdf_long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf_short = new SimpleDateFormat("yyyy-MM-dd");
		Date endDate = null;
		try{
			String[] endDates = endTime.split(" ");
			//如果终保时间为24点，则处理：终保日期往前推一天，终保小时为24点
			if (endDates.length > 1 && (endDates[1].substring(0, 2).equals("00") || endDates[1].substring(0, 2).equals("24"))) {
				Calendar date = Calendar.getInstance();
				date.setTime(sdf_long.parse(endTime));
				// 获取前一天
				date.add(Calendar.DAY_OF_MONTH, -1);
				endDate = sdf_short.parse(sdf_long.format(date.getTime()));
			}else {
				endDate = sdf_short.parse(endTime);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return endDate;
	}

	/**
	 * 对终保时间，获得终保小时
	 * @param endTime
	 * @return Integer
	 * @throws ParseException
	 */
	public static Integer getEndHour(Date endTime) {
		SimpleDateFormat sdf_long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf_short = new SimpleDateFormat("yyyy-MM-dd");
		Integer endHour = null;
		String[] endDates = sdf_long.format(endTime).split(" ");
		//如果终保时间为24点，则处理：终保日期往前推一天，终保小时为24点
		if (endDates.length > 1 && (endDates[1].substring(0, 2).equals("00") || endDates[1].substring(0, 2).equals("24"))) {
			endHour = 24;
		}else {
			endHour = endTime.getHours();
		}
		return endHour;
	}


	/**
	 * 对字符串yyyy-MM-dd HH:mm:ssd的终保时间，获得终保小时
	 * @param endTime
	 * @return Integer
	 * @throws ParseException
	 */
	public static Integer getEndHourOfString (String endTime) {
		SimpleDateFormat sdf_long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Integer endHour = null;
		String[] endDates = endTime.split(" ");
		//如果终保时间为24点，则处理：终保日期往前推一天，终保小时为24点
		if (endDates.length > 1 && (endDates[1].substring(0, 2).equals("00") || endDates[1].substring(0, 2).equals("24"))) {
			endHour = 24;
		}else {
			try {
				endHour = sdf_long.parse(endTime).getHours();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return endHour;
	}


	/**
	 * yyyy-MM-dd HH:mm:ss字符串转换成yyyy-MM-dd日期
	 */
	public static Date yyyyMMddHHmmssStrToDate(String str) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static void main(String[] args) {
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Date date = null;
		//try {
		//	date = format.parse("2023-11-11 12:00:00");
		//}catch (Exception e){
		//
		//}
		//Date date1 = getyyyyMMddDate(date);

		Date endDateOfString = getEndDateOfString("2023-11-11 12:00:00");
		Date endDateOfString1 = getEndDateOfString("2023-11-11 00:00:00");
		Date endDateOfString2 = getEndDateOfString("2023-11-11 24:00:00");
		Date endDateOfString4 = getEndDateOfString("2023-11-11 1:00:00");
		Integer endHourOfString = getEndHourOfString("2023-11-11 1:00:00");
		Integer endHourOfString1 = getEndHourOfString("2023-11-11 24:00:00");
		Integer endHourOfString2 = getEndHourOfString("2023-11-11 00:00:00");
		Integer endHourOfString3 = getEndHourOfString("2023-11-11 1:00:00");
	}
}
