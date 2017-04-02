package common;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;


/**
 * ×Ö·û´®°ïÖúÀà
 * Created by chen.Tian on 2017/3/21.
 */
public class StringHelper {

    /**
     * ×Ö·û´®×ª»»Îª×Ö½Ú´®
     *
     * @param value   ×Ö·û´®
     * @param charset ×Ö·û¼¯
     * @return ×Ö½Ú´®
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
     * ×Ö½Ú´®×ª»»Îª×Ö·û´®
     *
     * @param value   ×Ö½Ú´®
     * @param charset ×Ö·û¼¯
     * @return×Ö·û´®
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
