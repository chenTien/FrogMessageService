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
     * ����ʱ���ʽ��
     */
    public static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * ���ڸ�ʽ
     */
    public static String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * Ĭ�Ϲ��췽��
     */
    public DateHelper() {

    }

    /**
     * DATE����ת��Ϊʱ���ַ���
     *
     * @param date ��ת������
     * @return ʱ���ַ���
     */
    public static String date2String(Date date) {
        String pattern = DATE_FORMAT;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * DATETIME����ת��Ϊ����ʱ���ַ���
     *
     * @param date ��ת������ʱ��
     * @return ����ʱ���ַ���
     */
    public static String datetime2String(Date date) {
        String pattern = DATETIME_FORMAT;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     * �����ַ��������ڶ����ת��
     *
     * @param date ��ת����ʱ���ַ���
     * @return ���ڶ���
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
     * ����ʱ���ַ���������ʱ���ת��
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
     * ���ݿ�ʱ��ת��Ϊjava����ʱ��
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
     * ��ȡ��ǰʱ���ַ���
     *
     * @return
     */
    public static String getTodayStr() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(new Date());
    }

    /**
     * ��������ַ���
     *
     * @param dateString  �����ַ���
     * @param formatStyle ���ڸ�ʽ
     * @return
     */
    public static boolean checkDate(String dateString, String formatStyle) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStyle);
        try {
            //�����ַ���ת��Ϊ���ڶ���
            Date date = simpleDateFormat.parse(dateString);
            //���ڶ���ת��Ϊ�����ַ���
            String formatDate = simpleDateFormat.format(date);
            //����ת������ַ����Ƿ���ȷ
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
        // ���ڸ�ʽ���������ڶ���ת��Ϊ�����ַ���
        return simpleDateFormat.format(new Date());
    }

    public String dateTime2String(Date date, String pattern) {
        // �������ڸ�ʽ������
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        // ���ڸ�ʽ���������ڶ���ת��Ϊ����ʱ���ַ���
        return simpleDateFormat.format(date);
    }

    public static Date string2Datetime(String date, String pattern) {
        // �������ڸ�ʽ������
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            // ���ڸ�ʽ���������ڶ���ת��Ϊ����ʱ���ַ���
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
