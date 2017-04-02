package common;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;


/**
 * �ַ���������
 * Created by chen.Tian on 2017/3/21.
 */
public class StringHelper {

    /**
     * �ַ���ת��Ϊ�ֽڴ�
     *
     * @param value   �ַ���
     * @param charset �ַ���
     * @return �ֽڴ�
     */
    public static byte[] getBytes(String value, String charset) {
        if (value == null) {
            return null;
        }
        if (StringUtils.isEmpty(charset)) {
            return value.getBytes();
        } else {
            try {
                return value.getBytes(charset);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * �ֽڴ�ת��Ϊ�ַ���
     *
     * @param value   �ֽڴ�
     * @param charset �ַ���
     * @return�ַ���
     */
    public static String toString(byte[] value, String charset) {
        if (value == null) {
            return null;
        }
        if (StringUtils.isEmpty(charset)) {
            return new String(value);
        } else {
            try {
                return new String(value, charset);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
