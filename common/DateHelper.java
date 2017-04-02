package common;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chen.Tian on 2017/3/20.
 */
public class DateHelper {
    /**
     * 日期时间格式化
     */
    public static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 日期格式
     */
    public static String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 默认构造方法
     */
    public DateHelper() {

    }

    /**
     * DATE对象转换为时间字符串
     *
     * @param date 待转换日期
     * @return 时间字符串
     */
    public static String date2String(Date date) {
        String pattern = DATE_FORMAT;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * DATETIME对象转换为日期时间字符串
     *
     * @param date 待转换日期时间
     * @return 日期时间字符串
     */
    public static String datetime2String(Date date) {
        String pattern = DATETIME_FORMAT;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * 日期字符串到日期对象的转换
     *
     * @param date 待转换的时间字符串
     * @return 日期对象
     */
    public static Date string2Date(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date returnDate = null;
        try {
            returnDate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("String to date error! date = " + date);
            return returnDate;
        }
        return returnDate;
    }

    /**
     * 日期时间字符串到日期时间的转换
     *
     * @param date
     * @return
     */
    public static Date string2Datetime(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_FORMAT);
        Date returnDatetime = null;
        try {
            returnDatetime = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("String to datetime error! date = " + date);
            return returnDatetime;
        }
        return returnDatetime;
    }

    /**
     * 数据库时间转换为java对象时间
     *
     * @param date
     * @return
     */
    public static Date date2Date(Date date) {
        if (date == null) {
            return null;
        }
        if ((date instanceof java.sql.Date) || (date instanceof java.sql.Timestamp)) {
            return new Date(date.getTime());
        } else {
            return date;
        }
    }

    /**
     * 获取当前时间字符串
     *
     * @return
     */
    public static String getTodayStr() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(new Date());
    }

    /**
     * 检查日期字符串
     *
     * @param dateString  日期字符串
     * @param formatStyle 日期格式
     * @return
     */
    public static boolean checkDate(String dateString, String formatStyle) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStyle);
        try {
            //日期字符串转换为日期对象
            Date date = simpleDateFormat.parse(dateString);
            //日期对象转换为日期字符串
            String formatDate = simpleDateFormat.format(date);
            //检验转换后的字符串是否正确
            if (StringUtils.equals(dateString, formatDate)) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
    }

    public static String getNowTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmm");
        // 日期格式化对象将日期对象转换为日期字符串
        return simpleDateFormat.format(new Date());
    }

    public String dateTime2String(Date date, String pattern) {
        // 创建日期格式化对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        // 日期格式化对象将日期对象转换为日期时间字符串
        return simpleDateFormat.format(date);
    }

    public static Date string2Datetime(String date, String pattern) {
        // 创建日期格式化对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            // 日期格式化对象将日期对象转换为日期时间字符串
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
