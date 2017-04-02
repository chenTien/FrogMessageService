package common;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chen.Tian on 2017/3/20.
 */
public class FileDigest {

    /**
     * ��ȡ�����ļ���MD5ֵ��
     *
     * @param file
     * @return
     */
    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            return getFileMD5(inputStream);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    /**
     * ��ȡ�����ļ���MD5ֵ��
     * @param inputStream
     * @return
     */
    public static String getFileMD5(InputStream inputStream) {
        MessageDigest digest = null;
        byte[] buffer = new byte[1024];
        int len;

        try {
            digest = MessageDigest.getInstance("MD5");
            while ((len = inputStream.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                inputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        BigInteger bigInteger = new BigInteger(1,digest.digest());
        return bigInteger.toString().toUpperCase();
    }

    /**
     * ��ȡ�ļ����е�MD5ֵ
     * @param file
     * @param listChild
     *          �ݹ���Ŀ¼�е��ļ�
     * @return
     */
    public static Map<String,String> getDirMD5(File file,boolean listChild) {
        if (!file.isDirectory()) {
            return null;
        }
        Map<String,String> map = new HashMap<String,String>();
        String md5;
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File f = files[i];
            if (f.isDirectory() && listChild) {
                map.putAll(getDirMD5(f,listChild));
            } else {
                md5 = getFileMD5(f);
                if(md5 != null){
                    map.put(f.getPath(),md5);
                }
            }
        }
        return map;
    }
}
