package common;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

/**
 * �ļ�����������
 * Created by chen.Tian on 2017/3/21.
 */
public class FileHelper {

    /**
     * �ж��ļ��Ƿ����
     *
     * @param path �ļ�·��
     * @return �ļ��Ƿ����
     */
    public static boolean fileExist(String path) {
        File file = new File(path);
        return file.isFile() && file.exists();
    }

    /**
     * �ж�Ŀ¼�Ƿ����
     *
     * @param path Ŀ¼·��
     * @return Ŀ¼�Ƿ����
     */
    public static boolean dirExist(String path) {
        File dir = new File(path);
        return dir.isDirectory() && dir.exists();
    }

    /**
     * ����ָ��Ŀ¼��������Ŀ¼
     *
     * @param path Ŀ¼·��
     */
    public static void createDir(String path) {
        try {
            File dir = new File(path);
            FileUtils.forceMkdir(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ����Ŀ¼
     *
     * @param path Ŀ¼·��
     * @throws IOException
     */
    public static void createDirIfNecessary(String path) throws IOException {
        String dir = FilenameUtils.getFullPath(path);
        if (!FileHelper.dirExist(dir)) {
            FileHelper.createDir(path);
        }
    }

    /**
     * ��ȡ�ļ�����·��
     *
     * @param path �ļ�·��
     * @return �ļ�����·��
     */
    public static String getAbsoutePath(String path) {
        File file = new File(path);
        return file.getAbsolutePath();
    }
}
